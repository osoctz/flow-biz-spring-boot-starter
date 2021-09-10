package cn.metaq.flow.engine.impl;

import cn.metaq.common.exception.BusinessException;
import cn.metaq.flow.constant.TaskStatus;
import cn.metaq.flow.dao.*;
import cn.metaq.flow.domain.*;
import cn.metaq.flow.dto.FormDataDTO;
import cn.metaq.flow.engine.RuntimeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefaultRuntimeService implements RuntimeService {

    private static final Logger logger = LogManager.getLogger();

    @Resource
    private FlowDao flowDao;
    @Resource
    private StepDao stepDao;
    @Resource
    private DecisionDao decisionDao;
    @Resource
    private FlowExecutionDao flowExecutionDao;
    @Resource
    private StepExecutionDao stepExecutionDao;
    @Resource
    private CommentDao commentDao;
    @Resource
    private TaskDao taskDao;

    @Override
    public StepExecution start(FormDataDTO form) {
        //查询启动的流程
        Optional<Flow> fo = flowDao.findById(form.getFlowId());
        if (!fo.isPresent()) {
            throw new BusinessException("没有流程:" + form.getFlowId());
        }

        Flow flow = fo.get();
        //新增流程执行记录
        FlowExecution flowExecution = new FlowExecution();
        flowExecution.setFlowId(flow.getId());
        flowExecution.setBusinessKey(form.getBusiness_key());
        flowExecution.setCreatedTime(LocalDateTime.now());
        flowExecution.setCreatedBy(form.getApprovedBy());

        //查询流程的起始节点
        Optional<Step> so = stepDao.findOne((Specification<Step>) (root, cq, cb)
                -> cb.and(cb.equal(root.get("flowId"), flow.getId()), root.get("prev").isNull()));

        if (!so.isPresent()) {
            throw new BusinessException(flow.getId() + " 流程没有起始节点");
        }

        Step step = so.get();
        //查询决断对应流程状态及流转节点
        if (!decide(form, flowExecution, step.getId())) return null;
        //流程执行记录
        flowExecutionDao.save(flowExecution);
        //节点执行记录
        StepExecution stepExecution = this.createStepExecution(form, flowExecution, step);
        //审批意见
        this.createComment(form, stepExecution);
        //待办任务
        Task task = createTask(form, flowExecution);

        taskDao.save(task);
        return stepExecution;
    }

    @Override
    public StepExecution execute(FormDataDTO form) {
        Objects.requireNonNull(form.getFlowExecutionId(), "流程执行id必须不为空");

        //流程记录
        Optional<FlowExecution> ofe = flowExecutionDao.findById(form.getFlowExecutionId());
        if (ofe.isPresent()) {
            FlowExecution flowExecution = ofe.get();
            //1.当前执行节点
            Long currentStepId = flowExecution.getCurrent();
            if (!decide(form, flowExecution, currentStepId)) return null;

            Optional<Step> currentStep = stepDao.findById(currentStepId);
            StepExecution stepExecution = this.createStepExecution(form, flowExecution, currentStep.get());
            //2.审批意见
            this.createComment(form, stepExecution);
            //3.更新流程状态,下一节点
            this.updateFlowExecution(form, flowExecution);
            //4.更新我的待办状态
            updateMyTask(form);
            //5.创建指派人待办任务
            Task task = this.createTask(form, flowExecution);
            taskDao.save(task);

            return stepExecution;
        }

        throw new BusinessException(form.getFlowExecutionId() + " 流程不存在或被删除");
    }

    @Override
    public StepExecution end(FormDataDTO form) {
        Objects.requireNonNull(form.getFlowExecutionId(), "流程执行id必须不为空");
        //流程记录
        Optional<FlowExecution> ofe = flowExecutionDao.findById(form.getFlowExecutionId());
        if (ofe.isPresent()) {

            FlowExecution flowExecution = ofe.get();
            //1.当前节点到办结的流转
            Long currentStepId = flowExecution.getCurrent();
            Optional<Decision> od = decisionDao.findOne((Specification<Decision>) (root, cq, cb) -> {

                Subquery subquery = cq.subquery(Decision.class);
                Root subRoot = subquery.from(Decision.class);
                subquery.select(subRoot).where(cb.equal(root.get("next"), subRoot.get("stepId")));

                return cb.and(cb.equal(root.get("stepId"), currentStepId), cb.not(cb.exists(subquery)));
            });

            if (od.isPresent()) {

                Decision d = od.get();
                flowExecution.setStatus(d.getFlowStatus());
                flowExecution.setCurrent(d.getNext());
            } else {
                throw new BusinessException("分支 " + currentStepId + "_" + form.getDecision() + "不能直接办结.");
            }

            Optional<Step> currentStep = stepDao.findById(currentStepId);
            StepExecution stepExecution = this.createStepExecution(form, flowExecution, currentStep.get());
            //2.审批意见
            this.createComment(form, stepExecution);
            //3.更新流程状态,下一节点
            this.updateFlowExecution(form, flowExecution);
            //4.更新我的待办状态
            this.updateMyTask(form);
        }
        return null;
    }

    @Override
    public StepExecution stop(FormDataDTO form) {
        return null;
    }

    @Override
    public StepExecution resume(FormDataDTO form) {
        return null;
    }

    @Override
    public StepExecution pause(FormDataDTO form) {
        return null;
    }

    /**
     * 创建待办任务
     *
     * @param form
     * @param flowExecution
     * @return
     */
    private Task createTask(FormDataDTO form, FlowExecution flowExecution) {

        Task task = new Task();
        task.setFlowExecutionId(flowExecution.getId());
        task.setAssignee(form.getAssignee());
        task.setCreatedBy(form.getApprovedBy());
        task.setCreatedTime(LocalDateTime.now());
        task.setStatus(TaskStatus.DONE.value());

        Optional<Step> os = stepDao.findById(flowExecution.getCurrent());
        task.setTitle(os.get().getName());
        return task;
    }

    /**
     * 更新我的待办状态
     *
     * @param form
     */
    private void updateMyTask(FormDataDTO form) {
        Optional<Task> ot = taskDao.findOne((Specification<Task>) (root, cq, cb) -> {
            return cb.and(cb.equal(root.get("assignee"), form.getApprovedBy()), cb.equal(root.get("flowExecutionId"), form.getFlowExecutionId()));
        });

        if (ot.isPresent()) {
            Task task = ot.get();
            task.setStatus(TaskStatus.DONE.value());
            taskDao.save(task);
        }
    }

    /**
     * 新增步骤执行记录
     *
     * @param form
     * @param flowExecution
     * @param step
     * @return
     */
    private StepExecution createStepExecution(FormDataDTO form, FlowExecution flowExecution, Step step) {

        StepExecution stepExecution = new StepExecution();
        stepExecution.setFlowExecutionId(flowExecution.getId());
        stepExecution.setStepId(step.getId());
        stepExecution.setDecision(form.getDecision());
        stepExecution.setCreatedTime(LocalDateTime.now());
        stepExecution.setCreatedBy(form.getApprovedBy());
        stepExecution.setStatus(flowExecution.getStatus());
        stepExecution.setDescription("执行流程步骤:" + step.getName());

        stepExecutionDao.save(stepExecution);
        return stepExecution;
    }

    /**
     * 更新流程状态,下一节点
     *
     * @param form
     * @param flowExecution
     */
    private void updateFlowExecution(FormDataDTO form, FlowExecution flowExecution) {
        flowExecution.setLastUpdatedBy(form.getApprovedBy());
        flowExecution.setLastUpdated(LocalDateTime.now());
        flowExecutionDao.save(flowExecution);
    }

    /**
     * 新增审批意见
     *
     * @param form
     * @param stepExecution
     */
    private void createComment(FormDataDTO form, StepExecution stepExecution) {

        Comment comment = new Comment();
        comment.setStepExecutionId(stepExecution.getId());
        comment.setComment(form.getComment());
        comment.setCreatedBy(form.getApprovedBy());
        comment.setCreatedTime(LocalDateTime.now());
        comment.setApprovedBy(form.getApprovedBy());

        commentDao.save(comment);
    }

    /**
     * 步骤节点抉择
     * @param form
     * @param flowExecution
     * @param stepId
     * @return false 不需要抉择
     */
    private boolean decide(FormDataDTO form, FlowExecution flowExecution, Long stepId) {

        Optional<Decision> od = decisionDao.findOne((Specification<Decision>) (root, cq, cb) ->
                cb.and(cb.equal(root.get("stepId"), stepId),
                        cb.equal(root.get("decision"), form.getDecision())));

        if (od.isPresent()) {

            Decision d = od.get();
            if (Objects.isNull(d.getNext())) {
                logger.warn("流程已到办结节点.");
                return false;
            }

            flowExecution.setStatus(d.getFlowStatus());
            flowExecution.setCurrent(d.getNext());
        } else {
            throw new BusinessException("无流程 " + stepId + ":" + form.getDecision() + "流转分支");
        }

        return true;
    }
}
