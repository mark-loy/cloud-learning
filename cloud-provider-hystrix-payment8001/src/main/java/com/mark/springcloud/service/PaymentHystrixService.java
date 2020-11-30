package com.mark.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/24 11:32
 */
@Service
public class PaymentHystrixService {

    public String hystrixOK(Long id) {
        return "当前线程：" + Thread.currentThread().getName() + "请求id：" + id;
    }

    // 服务降级配置
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            // 超时时间设置
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String hystrixTimeout(Long id)  {
        long time = 3;
        try {
            // 程序暂停3s，模拟复杂业务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程：" + Thread.currentThread().getName() + " 请求id：" + id + " 耗时：" + time;
    }

    public String hystrixTimeoutHandler(Long id) {
        return "当前线程：" + Thread.currentThread().getName() + " 请求id：" + id + "服务器错误，请稍后再试";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
