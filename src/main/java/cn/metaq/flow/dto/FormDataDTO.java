package cn.metaq.flow.dto;

public class FormDataDTO {

    /**
     * 流程
     */
    private Long flowId;

    /**
     * 流程执行id
     */
    private Long flowExecutionId;

    /**
     * 通过/不通过
     */
    private Integer decision;

    /**
     * 业务key
     */
    private Long business_key;

    /**
     * 审批人
     */
    private String approvedBy;

    /**
     * 分配到任务的人
     */
    private String assignee;

    /**
     * 意见
     */
    private String comment;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public Long getFlowExecutionId() {
        return flowExecutionId;
    }

    public void setFlowExecutionId(Long flowExecutionId) {
        this.flowExecutionId = flowExecutionId;
    }

    public Integer getDecision() {
        return decision;
    }

    public void setDecision(Integer decision) {
        this.decision = decision;
    }

    public Long getBusiness_key() {
        return business_key;
    }

    public void setBusiness_key(Long business_key) {
        this.business_key = business_key;
    }
}