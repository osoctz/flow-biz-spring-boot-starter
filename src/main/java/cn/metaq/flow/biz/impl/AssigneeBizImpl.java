package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.AssigneeBiz;
import cn.metaq.flow.dao.AssigneeDao;
import cn.metaq.flow.dto.AssigneeDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AssigneeBizImpl extends BaseBiz<AssigneeDTO, Long, AssigneeDao> implements AssigneeBiz {
    @Override
    public Specification map(AssigneeDTO source) {
        return null;
    }
}
