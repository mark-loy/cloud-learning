package com.mark.springcloud.controller;

import com.mark.springcloud.domain.CommonResult;
import com.mark.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:28
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/decr/account")
    public CommonResult decr(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        log.info("扣减账户开始");
        accountService.decr(userId, money);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("扣减账户结束");
        return new CommonResult(200, "账户金额扣减成功", null);
    }
}
