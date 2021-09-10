package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.DecisionBiz;
import cn.metaq.flow.dao.DecisionDao;
import cn.metaq.flow.domain.Decision;
import cn.metaq.flow.dto.DecisionDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecisionBizImpl extends BaseBiz<DecisionDTO, Long, DecisionDao> implements DecisionBiz {

    @Override
    public void save(DecisionDTO decisionDTO) {

        Decision decision = new Decision();

        decision.setStepId(decisionDTO.getStepId());
        decision.setNext(decisionDTO.getNext());
        decision.setFlowStatus(decisionDTO.getFlowStatus());
        decision.setDecision(decisionDTO.getDecision());
        decision.setDescription(decisionDTO.getDescription());

        dao.save(decision);
    }

    @Override
    public void update(DecisionDTO decisionDTO) {

        Optional<Decision> dp = dao.findById(decisionDTO.getId());

        Decision decision = dp.orElseThrow();

        decision.setStepId(decisionDTO.getStepId());
        decision.setNext(decisionDTO.getNext());
        decision.setFlowStatus(decisionDTO.getFlowStatus());
        decision.setDecision(decisionDTO.getDecision());
        decision.setDescription(decisionDTO.getDescription());
        dao.save(decision);
    }

    @Override
    public Specification map(DecisionDTO source) {
        return null;
    }
}
