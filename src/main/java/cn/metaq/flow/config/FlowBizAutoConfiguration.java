package cn.metaq.flow.config;

import cn.metaq.data.jpa.QueryWrapperMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cn.metaq.flow"})
public class FlowBizAutoConfiguration {

    @Bean
    public QueryWrapperMapper queryWrapperMapper(){
        return new QueryWrapperMapper();
    }
}
