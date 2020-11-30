package com.mark.springcloud.controller;

import com.mark.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/24 15:57
 */
@RestController
// 通过服务降级fallback方法
@DefaultProperties(defaultFallback = "findByIdTimeoutGlobalHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/get/ok/{id}")
    public String getId(@PathVariable("id") Long id) {
        return paymentHystrixService.findByIdOK(id);
    };

    @GetMapping("/consumer/payment/get/timeout/{id}")
    // 指明了fallback方法，就会使用指明的方法
    @HystrixCommand(fallbackMethod = "findByIdTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getIdTimeout(@PathVariable("id") Long id) {
        //int a = 10 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentHystrixService.findByIdTimeout(id);
    };

    /**
     * 特定的fallback方法
     * @param id
     * @return
     */
    public String findByIdTimeoutHandler(Long id) {
        return "消费者80，请求失败，请稍后再试";
    }

    /**
     * 通用的fallback方法
     * @return
     */
    public String findByIdTimeoutGlobalHandler() {
        return "全局处理-----------消费者80，请求失败，请稍后再试";
    }
}
