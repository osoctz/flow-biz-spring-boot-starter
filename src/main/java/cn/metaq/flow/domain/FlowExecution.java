package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 流程执行记录
 */
@Entity
@Table(name = "t_ru_flow_execution")
@Data
public class FlowExecution implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 流程
     */
    @Column(name = "flow_id")
    private Long flowId;

    /**
     * 业务id
     */
    @Column(name = "business_key")
    private Long businessKey;

    /**
     * 当前步骤
     */
    @Column(name = "current")
    private Long current;

    /**
     * 状态
     * 不同流程定义，流程的枚举状态不同
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建者
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private java.time.LocalDateTime createdTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_updated")
    private java.time.LocalDateTime lastUpdated;

    /**
     * 创建者
     */
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

}
