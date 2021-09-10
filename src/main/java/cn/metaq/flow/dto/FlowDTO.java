package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class FlowDTO implements IDto {

    private Long id;
    private String name;
}
