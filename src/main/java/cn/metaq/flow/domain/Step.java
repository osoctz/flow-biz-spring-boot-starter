package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 流程步骤定义
 */
@Entity
@Table(name = "t_re_step")
@Data
public class Step implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name" )
    private String name;

    /**
     * 流程id
     */
    @Column(name = "flow_id" )
    private Long flowId;

    /**
     * 上一步骤
     */
    @Column(name = "prev" )
    private Long prev;

    /**
     * 委托接口class
     */
    @Column(name = "delegate" )
    private String delegate;
}
