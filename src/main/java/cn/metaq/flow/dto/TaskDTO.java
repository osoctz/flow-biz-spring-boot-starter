package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

/**
 * @see cn.metaq.flow.domain.Task
 */
@Data
public class TaskDTO implements IDto {

    private Long id;
    private String title;
    private Long flowExecutionId;
    private String assignee;
    private Integer status;
}
