package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 决断(流程-步骤状态配置表), step_id+decision+flow_status 控制流程下个流转
 */
@Entity
@Table(name = "t_re_decision")
@Data
public class Decision implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 步骤
     */
    @Column(name = "step_id")
    private Long stepId;

    /**
     * 决断: 1-通过 2-驳回 99-错误
     */
    @Column(name = "decision")
    private Integer decision;

    /**
     * 流程状态
     */
    @Column(name = "flow_status")
    private Integer flowStatus;

    /**
     * 下一步骤
     */
    @Column(name = "next")
    private Long next;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;
}