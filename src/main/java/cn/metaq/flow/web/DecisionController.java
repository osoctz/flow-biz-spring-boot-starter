package cn.metaq.flow.web;

import cn.metaq.common.web.BaseController;
import cn.metaq.flow.biz.DecisionBiz;
import cn.metaq.flow.domain.Decision;
import cn.metaq.flow.dto.DecisionDTO;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
public class DecisionController extends BaseController<DecisionBiz> {

    @PostMapping("decisions")
    public void add(@RequestBody DecisionDTO decisionDTO) {

        baseBiz.save(decisionDTO);
    }

    @PutMapping("decisions")
    public void update(@RequestBody DecisionDTO decisionDTO) {

        baseBiz.update(decisionDTO);
    }

    @DeleteMapping("decisions/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(null,id);
    }

    @GetMapping("decisions/{id}")
    public Decision view(@PathVariable Long id) {

        return baseBiz.getOneById(Decision.class,id);
    }
}
