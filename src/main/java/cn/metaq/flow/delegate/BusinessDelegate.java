package cn.metaq.flow.delegate;

import cn.metaq.flow.dto.StepExecutionResult;

/**
 * 委托具体业务实现接口
 */
public interface BusinessDelegate {

    StepExecutionResult execute(String businessKey, String flowExecutionId);
}