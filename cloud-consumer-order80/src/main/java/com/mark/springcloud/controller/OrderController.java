package com.mark.springcloud.controller;

import com.mark.springcloud.entity.CommonResult;
import com.mark.springcloud.entity.Payment;
import com.mark.springcloud.lb.MyLB;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Author LSQ
 * Date 2020/11/16 15:19
 * Version 1.0
 */
@RestController
public class OrderController {
    /**
     * 定义服务提供者的基础路径
     */
    public static final String BASE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(BASE_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(BASE_URL + "/payment/get/" + id, CommonResult.class);
    }

    @Resource
    private MyLB myLB;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult get(@PathVariable("id") Long id) {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = myLB.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }
}
