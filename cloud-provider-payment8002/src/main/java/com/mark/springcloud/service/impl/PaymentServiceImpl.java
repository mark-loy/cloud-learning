package com.mark.springcloud.service.impl;

import com.mark.springcloud.dao.PaymentDao;
import com.mark.springcloud.entity.Payment;
import com.mark.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author LSQ
 * Date 2020/11/16 12:00
 * Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
