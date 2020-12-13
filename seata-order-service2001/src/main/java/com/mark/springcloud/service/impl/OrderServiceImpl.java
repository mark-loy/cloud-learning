package com.mark.springcloud.service.impl;

import com.mark.springcloud.dao.OrderDao;
import com.mark.springcloud.domain.Order;
import com.mark.springcloud.service.AccountService;
import com.mark.springcloud.service.OrderService;
import com.mark.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 13:58
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-tx-group", rollbackFor = {Exception.class})
    public int createOrder(Order order) {
        log.info("创建订单开始");
        orderDao.create(order);
        log.info("创建订单结束");

        log.info("库存数量扣减开始");
        storageService.decr(order.getProductId(), order.getCount());
        log.info("库存数量扣减结束");

        log.info("账户金额扣减开始");
        accountService.decr(order.getUserId(), order.getMoney());
        log.info("账户金额扣减结束");

        log.info("修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("修改订单状态结束");
        return 0;
    }
}
