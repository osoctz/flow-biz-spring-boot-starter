package cn.metaq.flow.dto;

import cn.metaq.common.core.IDto;
import lombok.Data;

@Data
public class CommentDTO implements IDto {

    private Long id;
    private Long stepExecutionId;
    private String approvedBy;
    private String createdBy;
    private String comment;
}
