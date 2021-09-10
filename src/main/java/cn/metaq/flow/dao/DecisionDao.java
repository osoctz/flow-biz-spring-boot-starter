package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Decision;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionDao extends BaseDao<Decision, Long> {

    void deleteByStepId(Long stepId);
}
