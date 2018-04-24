package com.test.activemq.both;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author: wuwei
 * @date: 2018/4/24 11:28
 */
@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    private static int count = 0;

    @Scheduled(fixedDelay = 3 * 1000)
    public void send() {
        jmsMessagingTemplate.convertAndSend(queue, "hi, activeMQ(queue), index=" + count);
        jmsMessagingTemplate.convertAndSend(topic, "hi, activeMQ(topic), index=" + count++);
    }
}
