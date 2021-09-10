package cn.metaq.flow.engine;

import cn.metaq.flow.domain.StepExecution;
import cn.metaq.flow.dto.FormDataDTO;

/**
 * 流程运行服务接口
 */
public interface RuntimeService {

    StepExecution start(FormDataDTO form);

    StepExecution execute(FormDataDTO form);

    StepExecution end(FormDataDTO form);

    StepExecution stop(FormDataDTO form);

    StepExecution resume(FormDataDTO form);

    StepExecution pause(FormDataDTO form);
}