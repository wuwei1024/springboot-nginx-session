package com.test.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: wuwei
 * @date: 2018/4/24 10:18
 */
@Component
public class Consumer {
    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String msg) {
        System.out.println(msg);
    }
}
