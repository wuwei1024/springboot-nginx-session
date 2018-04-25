package com.test.pubsub;

import org.springframework.stereotype.Component;

/**
 * @author: wuwei
 * @date: 2018/3/23 15:29
 */
@Component
public class Subscriber {
    public void receiveMessage(String message) {
        System.out.println("收到一条消息：" + message);
    }
}
