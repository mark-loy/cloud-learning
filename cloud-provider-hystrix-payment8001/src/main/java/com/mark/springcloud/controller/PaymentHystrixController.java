package com.mark.springcloud.controller;

import com.mark.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/24 11:31
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/get/ok/{id}")
    public String findByIdOK(@PathVariable("id") Long id) {
        return paymentHystrixService.hystrixOK(id);
    }

    @GetMapping("/payment/get/timeout/{id}")
    public String findByIdTimeout(@PathVariable("id") Long id) {
        String hystrixTimeout = paymentHystrixService.hystrixTimeout(id);
        log.info("result: " + hystrixTimeout);
        return hystrixTimeout;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
