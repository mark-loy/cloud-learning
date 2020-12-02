package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 10:43
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQProvider8801.class, args);
    }
}
