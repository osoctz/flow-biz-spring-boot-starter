package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.FlowExecution;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowExecutionDao extends BaseDao<FlowExecution, Long> {
}
