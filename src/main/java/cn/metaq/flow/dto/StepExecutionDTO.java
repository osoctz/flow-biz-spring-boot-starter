package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class StepExecutionDTO implements IDto {

    private Long id;
    private Long stepId;
    private Long flowExecutionId;
    private Integer decision;
    private Integer status;
    private String description;
}
