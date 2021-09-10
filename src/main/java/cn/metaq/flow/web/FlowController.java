package cn.metaq.flow.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.flow.biz.FlowBiz;
import cn.metaq.flow.domain.Flow;
import cn.metaq.flow.dto.FlowDTO;
import org.springframework.web.bind.annotation.*;


@RestController
public class FlowController extends BaseController<FlowBiz> {

    @PostMapping("flows")
    public void add(@RequestBody FlowDTO flowDTO){

        baseBiz.save(flowDTO);
    }

    @PutMapping("flows")
    public void update(@RequestBody FlowDTO flowDTO){

        baseBiz.update(flowDTO);
    }

    @DeleteMapping("flows/{id}")
    public void delete(@PathVariable Long id){

        baseBiz.deleteById(null,id);
    }

    @GetMapping("flows/{id}")
    public Flow view(@PathVariable Long id){

       return baseBiz.getOneById(Flow.class,id);
    }

    @PostMapping("flows/pages")
    public Pagination<Flow> list(@RequestBody FlowDTO flowDTO, int offset, int limit) {

        return baseBiz.list(Flow.class,flowDTO, offset, limit);
    }
}
