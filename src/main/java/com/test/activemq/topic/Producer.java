package com.test.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 发布者
 *
 * @author: wuwei
 * @date: 2018/4/24 9:34
 */

public class Producer {
    private final static String URL = "tcp://localhost:61616";
    private final static String TOPIC_NAME = "topic-name";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        // 2. 创建Connection
        Connection connection = factory.createConnection();
        // 3. 启动连接
        connection.start();
        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标【与队列模式的区别就在这里，相当于发布一个主题】
        Destination dest = session.createTopic(TOPIC_NAME);
        // 6. 创建一个生产者
        MessageProducer producer = session.createProducer(dest);
        for (int i = 0; i < 10; i++) {
            // 7. 创建消息
            TextMessage msg = session.createTextMessage("消息" + i);
            // 8. 发布消息
            producer.send(msg);
            System.out.println(msg);
        }
        // 9. 关闭连接
        producer.close();
        session.close();
        connection.close();
    }
}
