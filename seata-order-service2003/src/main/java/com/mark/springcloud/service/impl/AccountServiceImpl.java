package com.mark.springcloud.service.impl;

import com.mark.springcloud.dao.AccountDao;
import com.mark.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:26
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decr(Long userId, BigDecimal money) {
        accountDao.decr(userId, money);
    }
}
