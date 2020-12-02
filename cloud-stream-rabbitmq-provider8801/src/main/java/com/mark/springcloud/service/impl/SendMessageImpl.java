package com.mark.springcloud.service.impl;

import com.mark.springcloud.service.SendMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 10:45
 */
@EnableBinding(Source.class)
public class SendMessageImpl implements SendMessage {

    @Resource
    private MessageChannel output;

    @Override
    public String sendUUID() {
        String uuid = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("send:" + uuid);
        if (!send) {
            return "发送消息失败";
        }
        return "发送消息成功";
    }
}
