package com.mark.springcloud.service;

import com.mark.springcloud.entity.Payment;

/**
 * Author LSQ
 * Date 2020/11/16 11:59
 * Version 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment findById(Long id);
}
