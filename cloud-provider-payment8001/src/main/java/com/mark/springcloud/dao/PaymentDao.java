package com.mark.springcloud.dao;

import com.mark.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Author LSQ
 * Date 2020/11/16 11:47
 * Version 1.0
 */
public interface PaymentDao {

    int create(Payment payment);

    Payment findById(@Param("id") Long id);

}
