package com.mark.springcloud.service;

import com.mark.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 14:02
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/decr/account")
    CommonResult decr(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
