package com.mark.springcloud.controller;

import com.mark.springcloud.entity.CommonResult;
import com.mark.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/23 15:30
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult findById(@PathVariable("id") Long id) {
        return paymentFeignService.findById(id);
    }

}
