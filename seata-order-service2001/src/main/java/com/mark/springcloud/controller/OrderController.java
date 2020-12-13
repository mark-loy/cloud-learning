package com.mark.springcloud.controller;

import com.mark.springcloud.domain.CommonResult;
import com.mark.springcloud.domain.Order;
import com.mark.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 15:03
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create/order")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return  new CommonResult(200, "订单支付成功", null);
    }

}
