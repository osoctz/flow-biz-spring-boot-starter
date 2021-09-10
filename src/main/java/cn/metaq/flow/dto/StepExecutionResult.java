package cn.metaq.flow.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StepExecutionResult {

    /**
     * 0-失败 1-成功
     */
    private Integer status;

    private String message;
}