package com.mark.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:19
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.mark.springcloud.dao")
public class SeataOrderMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2003.class, args);
    }
}
