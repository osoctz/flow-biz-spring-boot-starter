package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class FlowExecutionDTO implements IDto {

    private Long id;
    private Long flowId;
    private Long businessKey;
    private Long current;
    private Integer status;
}
