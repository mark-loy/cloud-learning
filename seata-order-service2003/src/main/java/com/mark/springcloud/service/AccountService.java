package com.mark.springcloud.service;

import java.math.BigDecimal;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:21
 */
public interface AccountService {

    void decr(Long userId, BigDecimal money);

}
