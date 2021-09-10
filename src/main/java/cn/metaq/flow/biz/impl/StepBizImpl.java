package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.QueryWrapperBiz;
import cn.metaq.flow.biz.StepBiz;
import cn.metaq.flow.dao.DecisionDao;
import cn.metaq.flow.dao.StepDao;
import cn.metaq.flow.domain.Step;
import cn.metaq.flow.dto.StepDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class StepBizImpl extends BaseBiz<StepDTO, Long, StepDao> implements StepBiz {

    @Resource
    private DecisionDao decisionDao;

    @Override
    public void save(StepDTO stepDTO) {

        Step step = new Step();

        step.setName(stepDTO.getName());
        step.setFlowId(stepDTO.getFlowId());
        step.setPrev(stepDTO.getPrev());
        step.setDelegate(stepDTO.getDelegate());

        dao.save(step);
    }

    @Override
    public void update(StepDTO stepDTO) {

        Optional<Step> sp = dao.findById(stepDTO.getId());

        Step step = sp.orElseThrow();
        step.setName(stepDTO.getName());
        step.setFlowId(stepDTO.getFlowId());
        step.setPrev(stepDTO.getPrev());
        step.setDelegate(stepDTO.getDelegate());

        dao.save(step);
    }

    @Override
    public void deleteById(Class clazz,Long id) {

        //删除step
        dao.deleteById(id);
        //删除decision
        decisionDao.deleteByStepId(id);
    }

    @Override
    public Specification map(StepDTO source) {
        return null;
    }
}
