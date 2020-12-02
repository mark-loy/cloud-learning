package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 13:36
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMQConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumer8803.class, args);
    }
}
