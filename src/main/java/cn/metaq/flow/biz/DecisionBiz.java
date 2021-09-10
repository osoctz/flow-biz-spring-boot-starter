package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.DecisionDTO;
import org.springframework.data.jpa.domain.Specification;

public interface DecisionBiz extends Biz<DecisionDTO, Long>, QueryBiz<DecisionDTO, Specification> {
}
