package cn.metaq.flow.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.flow.dto.TaskDTO;
import org.springframework.data.jpa.domain.Specification;

public interface TaskBiz extends Biz<TaskDTO,Long>, QueryBiz<TaskDTO, Specification> {
}
