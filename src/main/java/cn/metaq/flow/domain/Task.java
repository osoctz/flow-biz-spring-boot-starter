package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 待办任务
 */
@Entity
@Table(name = "t_ru_task")
@Data
public class Task implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title" )
    private String title;

    /**
     * 流程记录id
     */
    @Column(name = "flow_execution_id" )
    private Long flowExecutionId;

    /**
     * 指派执行人
     */
    @Column(name = "assignee" )
    private String assignee;

    /**
     * 待办任务状态, 0-待办 1-已解决
     * @see cn.metaq.flow.constant.TaskStatus
     */
    @Column(name = "status" )
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "created_time" )
    private java.time.LocalDateTime createdTime;

    /**
     * 创建者
     */
    @Column(name = "created_by" )
    private String createdBy;
}
