package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.AssigneeDTO;
import org.springframework.data.jpa.domain.Specification;

public interface AssigneeBiz extends Biz<AssigneeDTO,Long>, QueryBiz<AssigneeDTO, Specification> {
}
