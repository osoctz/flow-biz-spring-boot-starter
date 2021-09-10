package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.FlowBiz;
import cn.metaq.flow.dao.FlowDao;
import cn.metaq.flow.domain.Flow;
import cn.metaq.flow.dto.FlowDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlowBizImpl extends BaseBiz<FlowDTO, Long, FlowDao> implements FlowBiz {

    @Override
    public void save(FlowDTO flowDTO) {

        Flow flow = new Flow();
        flow.setName(flowDTO.getName());

        dao.save(flow);
    }

    @Override
    public void update(FlowDTO flowDTO) {

        Optional<Flow> fp = dao.findById(flowDTO.getId());

        Flow flow = fp.orElseThrow();
        flow.setName(flowDTO.getName());

        dao.save(flow);
    }

    @Override
    public Specification map(FlowDTO source) {
        return null;
    }
}
