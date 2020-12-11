package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/8 16:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9003.class, args);
    }
}
