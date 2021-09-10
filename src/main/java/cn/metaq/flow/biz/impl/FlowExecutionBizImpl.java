package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.FlowExecutionBiz;
import cn.metaq.flow.dao.FlowExecutionDao;
import cn.metaq.flow.dto.FlowExecutionDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FlowExecutionBizImpl extends BaseBiz<FlowExecutionDTO,Long, FlowExecutionDao> implements FlowExecutionBiz {
    @Override
    public Specification map(FlowExecutionDTO source) {
        return null;
    }
}
