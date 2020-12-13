package com.mark.springcloud.service;

import com.mark.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 14:01
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/decr/storage")
    CommonResult decr(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
