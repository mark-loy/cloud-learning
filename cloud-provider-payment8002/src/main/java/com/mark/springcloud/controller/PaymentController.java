package com.mark.springcloud.controller;

import com.mark.springcloud.entity.CommonResult;
import com.mark.springcloud.entity.Payment;
import com.mark.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author LSQ
 * Date 2020/11/16 12:02
 * Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功 port=" + serverPort, result);
        } else {
            return new CommonResult(401, "插入数据失败 port=" + serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult findById(@PathVariable("id") Long id) {

        Payment result = paymentService.findById(id);

        log.info("result: {}", result);

        if (result != null) {
            return new CommonResult(200, "查询数据成功 port=" + serverPort, result);
        } else {
            return new CommonResult(401, "查询数据:" + id + " 失败 port=" + serverPort);
        }
    }

}
