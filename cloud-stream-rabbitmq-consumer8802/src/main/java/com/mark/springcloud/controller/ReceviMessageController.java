package com.mark.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/2 11:07
 */
@EnableBinding(Sink.class) //开启接收消息通道
public class ReceviMessageController {

    @Value("${server.port}")
    private String port;

    /**
     * 返回值必须为void；否则报错
     * @param message
     */
    @StreamListener(Sink.INPUT) // 监听通道中的消息
    public void getMessage(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("消费者1号接受消息为：" + payload + " 端口：" + port);
    }

}
