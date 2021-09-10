package cn.metaq.flow.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.flow.domain.Step;
import org.springframework.stereotype.Repository;

@Repository
public interface StepDao extends BaseDao<Step,Long> {
}
