package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.CommentBiz;
import cn.metaq.flow.dao.CommentDao;
import cn.metaq.flow.dto.CommentDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CommentBizImpl extends BaseBiz<CommentDTO, Long, CommentDao> implements CommentBiz {
    @Override
    public Specification map(CommentDTO source) {
        return null;
    }
}
