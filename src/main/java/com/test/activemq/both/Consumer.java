package com.test.activemq.both;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: wuwei
 * @date: 2018/4/24 11:34
 */
@Component
public class Consumer {
    @JmsListener(destination = "sample.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue1(String msg) {
        System.out.println("Queue Consumer1: " + msg);
    }

    @JmsListener(destination = "sample.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue2(String msg) {
        System.out.println("Queue Consumer2: " + msg);
    }

    @JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic1(String msg) {
        System.out.println("Topic Consumer1: " + msg);
    }

    @JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String msg) {
        System.out.println("Topic Consumer2: " + msg);
    }
}
