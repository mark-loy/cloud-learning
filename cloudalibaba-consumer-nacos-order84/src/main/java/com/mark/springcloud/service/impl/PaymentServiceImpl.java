package com.mark.springcloud.service.impl;

import com.mark.springcloud.entity.CommonResult;
import com.mark.springcloud.entity.Payment;
import com.mark.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/10 11:37
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "请求失败***********/(ㄒoㄒ)/~~", null);
    }
}
