package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends BaseDao<Comment, Long> {
}
