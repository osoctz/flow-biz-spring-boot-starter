package cn.metaq.flow.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.flow.biz.TaskBiz;
import cn.metaq.flow.domain.Task;
import cn.metaq.flow.dto.TaskDTO;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaskController extends BaseController<TaskBiz> {

    @PostMapping("tasks")
    public void add(@RequestBody TaskDTO taskDTO) {

        baseBiz.save(taskDTO);
    }

    @PutMapping("tasks")
    public void update(@RequestBody TaskDTO taskDTO) {

        baseBiz.update(taskDTO);
    }

    @DeleteMapping("tasks/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(null, id);
    }

    @GetMapping("tasks/{id}")
    public Task view(@PathVariable Long id) {

        return baseBiz.getOneById(Task.class,id);
    }

    @PostMapping("tasks/pages")
    public Pagination<Task> list(@RequestBody TaskDTO taskDTO, int offset, int limit) {

        return baseBiz.list(Task.class,taskDTO, offset, limit);
    }
}
