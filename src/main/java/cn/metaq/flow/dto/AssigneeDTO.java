package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class AssigneeDTO implements IDto {

    private Long id;
    private Integer type;
    private String target;
    private Long stepId;
}
