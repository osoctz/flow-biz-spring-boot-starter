package cn.metaq.flow.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.data.jpa.QueryWrapperMapper;
import cn.metaq.flow.biz.StepBiz;
import cn.metaq.flow.domain.Step;
import cn.metaq.flow.dto.StepDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StepController extends BaseController<StepBiz> {

    @PostMapping("steps")
    public void add(@RequestBody StepDTO stepDTO) {

        baseBiz.save(stepDTO);
    }

    @PutMapping("steps")
    public void update(@RequestBody StepDTO stepDTO) {

        baseBiz.update(stepDTO);
    }

    @DeleteMapping("steps/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(null, id);
    }

    @GetMapping("steps/{id}")
    public Step view(@PathVariable Long id) {

        return baseBiz.getOneById(null, id);
    }

    @PostMapping("steps/pages")
    public Pagination<Step> list(@RequestBody StepDTO stepDTO, int offset, int limit) {

        return baseBiz.list(Step.class, stepDTO, offset, limit);
    }

}
