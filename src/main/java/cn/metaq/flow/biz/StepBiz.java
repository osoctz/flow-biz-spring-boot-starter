package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.StepDTO;
import org.springframework.data.jpa.domain.Specification;

public interface StepBiz extends Biz<StepDTO, Long>, QueryBiz<StepDTO, Specification> {
}
