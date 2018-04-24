package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author: wuwei
 * @date: 2018/4/24 10:06
 */
@RestController
@RequestMapping("/mq")
public class ProducerController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    @RequestMapping("/sendMsg")
    public String sendMsg(@RequestParam("msg") String msg) {
        jmsMessagingTemplate.convertAndSend(queue, msg);
        return "Message has been sent successfully!";
    }
}
