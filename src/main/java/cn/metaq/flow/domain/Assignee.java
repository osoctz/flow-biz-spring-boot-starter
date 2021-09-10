package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 流程节点指派人配置
 */
@Entity
@Table(name = "t_re_assignee")
@Data
public class Assignee implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 指派对象类型: 1-用户 2-角色 3-机构
     * @see cn.metaq.flow.constant.AssigneeType
     */
    @Column(name = "type" )
    private Integer type;

    /**
     * 具体指派对象值
     */
    @Column(name = "target" )
    private String target;

    /**
     * 步骤节点
     */
    @Column(name = "step_id" )
    private Long stepId;
}
