package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 11:05
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMQConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumer8802.class, args);
    }
}
