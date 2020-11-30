package com.mark.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/24 19:22
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{
    @Override
    public String findByIdOK(Long id) {
        return "----------error-----------OK";
    }

    @Override
    public String findByIdTimeout(Long id) {
        return "----------error----------TIMEOUT";
    }
}
