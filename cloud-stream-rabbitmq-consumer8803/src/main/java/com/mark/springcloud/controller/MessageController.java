package com.mark.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 13:37
 */
@EnableBinding(Sink.class)
public class MessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("消费者2号接受消息为：" + payload + " 端口：" + port);
    }

}
