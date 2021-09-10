package cn.metaq.flow.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.flow.biz.CommentBiz;
import cn.metaq.flow.domain.Comment;
import cn.metaq.flow.dto.CommentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController extends BaseController<CommentBiz> {

    @PostMapping("comments/pages")
    public Pagination<Comment> list(@RequestBody CommentDTO commentDTO, int offset, int limit) {

        return baseBiz.list(Comment.class,commentDTO, offset, limit);
    }
}
