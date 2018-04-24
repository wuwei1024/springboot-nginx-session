package com.test.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 订阅者
 *
 * @author: wuwei
 * @date: 2018/4/24 9:31
 */

public class Consumer {
    private final static String URL = "tcp://localhost:61616";
    private final static String TOPIC_NAME = "topic-name";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        // 2. 创建Connection
        Connection con = factory.createConnection();
        // 3. 启动连接
        con.start();
        // 4. 创建会话
        Session session = con.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标【与队列模式的区别就在这里，相当于订阅了该主题】
        Destination dest = session.createTopic(TOPIC_NAME);
        // 6. 创建一个消费者
        MessageConsumer consumer = session.createConsumer(dest);
        // 7. 创建一个监听器
        consumer.setMessageListener(message -> {
            TextMessage msg = (TextMessage) message;
            try {
                System.out.println("接收消息为：" + msg.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
        // 先不关闭，不然还没接收到消息就关闭了
        //con.close();
    }
}
