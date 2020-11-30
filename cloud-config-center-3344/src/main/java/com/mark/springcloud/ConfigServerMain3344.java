package com.mark.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/30 13:34
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3344.class, args);
    }
}
