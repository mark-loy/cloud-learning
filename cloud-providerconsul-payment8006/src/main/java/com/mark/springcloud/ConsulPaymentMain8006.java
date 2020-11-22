package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/22 14:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain8006.class, args);
    }
}
