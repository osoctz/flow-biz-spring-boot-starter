package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class DecisionDTO implements IDto {

    private Long id;
    private Long stepId;
    private Integer decision;
    private Integer flowStatus;
    private Long next;
    private String description;
}
