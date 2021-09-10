package cn.metaq.flow.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.flow.biz.TaskBiz;
import cn.metaq.flow.dao.TaskDao;
import cn.metaq.flow.dto.TaskDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TaskBizImpl extends BaseBiz<TaskDTO, Long, TaskDao> implements TaskBiz {
    @Override
    public Specification map(TaskDTO source) {
        return null;
    }
}
