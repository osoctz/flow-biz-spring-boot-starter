package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.StepExecutionBiz;
import cn.metaq.flow.dao.StepExecutionDao;
import cn.metaq.flow.dto.StepExecutionDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StepExecutionBizImpl extends BaseBiz<StepExecutionDTO, Long, StepExecutionDao> implements StepExecutionBiz {
    @Override
    public Specification map(StepExecutionDTO source) {
        return null;
    }
}
