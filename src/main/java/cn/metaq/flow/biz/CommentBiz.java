package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.CommentDTO;
import org.springframework.data.jpa.domain.Specification;

public interface CommentBiz extends Biz<CommentDTO, Long>, QueryBiz<CommentDTO, Specification> {
}
