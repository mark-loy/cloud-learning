package com.mark.springcloud.controller;

import com.mark.springcloud.domain.CommonResult;
import com.mark.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:08
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/decr/storage")
    public CommonResult decr(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        log.info("扣减库存开始");
        storageService.decr(productId, count);
        log.info("扣减库存结束");
        return new CommonResult(200, "库存扣减成功", null);
    }

}
