package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 流程步骤执行记录
 */
@Entity
@Table(name = "t_ru_step_execution")
@Data
public class StepExecution implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 流程步骤
     */
    @Column(name = "step_id" )
    private Long stepId;

    /**
     * 流程记录
     */
    @Column(name = "flow_execution_id" )
    private Long flowExecutionId;

    /**
     * 决断: 1-通过 2-驳回 99-错误
     */
    @Column(name = "decision" )
    private Integer decision;

    /**
     * 状态(流程状态)
     */
    @Column(name = "status" )
    private Integer status;

    /**
     * 流程步骤执行详细描述
     */
    @Column(name = "description" )
    private String description;


    @Column(name = "created_by" )
    private String createdBy;


    /**
     * 创建时间
     */
    @Column(name = "created_time" )
    private java.time.LocalDateTime createdTime;
}
