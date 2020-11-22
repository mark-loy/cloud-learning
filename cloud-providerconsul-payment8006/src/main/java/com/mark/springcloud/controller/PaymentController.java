package com.mark.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/22 14:59
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String payment() {
        return "SpringCloud with Consul port:" + port + " " + UUID.randomUUID().toString();
    }

}
