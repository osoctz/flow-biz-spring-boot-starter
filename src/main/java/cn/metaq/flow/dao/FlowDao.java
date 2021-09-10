package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Flow;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowDao extends BaseDao<Flow, Long> {
}
