package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class StepDTO implements IDto {

    private Long id;
    private String name;
    private Long flowId;
    private Long prev;
    private String delegate;
}
