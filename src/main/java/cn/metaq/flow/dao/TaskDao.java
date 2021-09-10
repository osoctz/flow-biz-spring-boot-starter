package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends BaseDao<Task, Long> {
}
