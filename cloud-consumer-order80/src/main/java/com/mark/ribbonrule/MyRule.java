package com.mark.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/22 18:57
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getRule() {
        return new RandomRule();
    }

}
