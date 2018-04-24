package com.test.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: wuwei
 * @date: 2018/4/24 10:18
 */
@Component
public class MsgConsumer {
    @JmsListener(destination = "sample.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String msg) {
        System.out.println("Queue MsgConsumer: " + msg);
    }

    @JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(String msg) {
        System.out.println("Topic MsgConsumer: " + msg);
    }
}
