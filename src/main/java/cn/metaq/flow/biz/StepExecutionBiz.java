package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.StepExecutionDTO;
import org.springframework.data.jpa.domain.Specification;

public interface StepExecutionBiz extends Biz<StepExecutionDTO,Long>, QueryBiz<StepExecutionDTO, Specification> {
}
