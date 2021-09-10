package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.FlowDTO;
import org.springframework.data.jpa.domain.Specification;

public interface FlowBiz extends Biz<FlowDTO,Long>, QueryBiz<FlowDTO, Specification> {
}
