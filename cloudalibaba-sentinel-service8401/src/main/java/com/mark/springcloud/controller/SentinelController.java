package com.mark.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/6 15:25
 */
@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/test/a")
    public String getTestA() {
        return "************Test A***************";
    }

    @GetMapping("/test/b")
    public String getTestB() {
        return "************Test B***************";
    }

    @GetMapping("/test/d")
    public String testD() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/test/e")
    public String testE() {
        log.info("testE 测试异常比例");
        int age = 10/0;
        return "------testE";
    }

    @GetMapping("/test/f")
    public String testF() {
        log.info("testF 测试异常数");
        int age = 10/0;
        return "------testF 测试异常数";
    }

    @GetMapping("/test/g")
    @SentinelResource(value = "testG", blockHandler = "handlerTestG")
    public String testG(@RequestParam(name = "p1", required = false) String p1,
                        @RequestParam(name = "p2", required = false) String p2) {
        return "------testG 测试热点key OK";
    }

    public String handlerTestG(String p1, String p2, BlockException e) {
        return "------testG 测试热点key /(ㄒoㄒ)/~~";
    }
}
