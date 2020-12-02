package com.mark.springcloud.controller;

import com.mark.springcloud.service.SendMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 10:51
 */
@RestController
public class SendMessageController {

    @Resource
    private SendMessage sendMessage;

    @GetMapping("/send/message")
    public String toMessage() {
        return sendMessage.sendUUID();
    }

}
