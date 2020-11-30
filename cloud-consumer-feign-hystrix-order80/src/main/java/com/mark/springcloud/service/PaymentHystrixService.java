package com.mark.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/24 15:57
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/get/ok/{id}")
    String findByIdOK(@PathVariable("id") Long id);

    @GetMapping("/payment/get/timeout/{id}")
    String findByIdTimeout(@PathVariable("id") Long id);
}
