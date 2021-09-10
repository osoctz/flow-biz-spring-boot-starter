package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.FlowExecutionDTO;
import org.springframework.data.jpa.domain.Specification;

public interface FlowExecutionBiz extends Biz<FlowExecutionDTO, Long>, QueryBiz<FlowExecutionDTO, Specification> {
}
