package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 审批意见
 */
@Entity
@Table(name = "t_ru_comment")
@Data
public class Comment implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 步骤
     */
    @Column(name = "step_execution_id" )
    private Long stepExecutionId;

    /**
     * 审批人
     */
    @Column(name = "approved_by" )
    private String approvedBy;

    /**
     * 创建人
     */
    @Column(name = "created_by" )
    private String createdBy;

    /**
     * 意见
     */
    @Column(name = "comment" )
    private String comment;

    /**
     * 审批时间
     */
    @Column(name = "created_time" )
    private java.time.LocalDateTime createdTime;
}