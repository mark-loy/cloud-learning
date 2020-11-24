package com.mark.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/23 16:28
 */
@Configuration
public class FeignLog {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
