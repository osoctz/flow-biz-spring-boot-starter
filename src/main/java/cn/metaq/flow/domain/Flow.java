package cn.metaq.flow.domain;

import cn.metaq.common.core.IEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_re_flow")
@Data
public class Flow implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    /**
     * 流程名称
     */
    @Column(name = "name")
    private String name;
}
