package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Assignee;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeDao extends BaseDao<Assignee, Long> {
}
