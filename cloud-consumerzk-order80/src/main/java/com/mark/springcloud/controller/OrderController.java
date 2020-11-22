package com.mark.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/22 11:32
 */
@RestController
public class OrderController {

    public static final String BASE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/order")
    public String order() {
        return restTemplate.getForObject(BASE_URL + "/payment/zk", String.class);
    }

}
