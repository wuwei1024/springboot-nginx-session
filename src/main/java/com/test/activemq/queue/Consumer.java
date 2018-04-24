package com.test.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消费者
 *
 * @author: wuwei
 * @date: 2018/4/23 18:09
 */

public class Consumer {
    /**
     * 中间件地址
     */
    private final static String URL = "tcp://localhost:61616";
    /**
     * 中间件队列名，与生产者的一致
     */
    private final static String QUEUE_NAME = "queue-name";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        // 2. 创建Connection
        Connection con = factory.createConnection();
        // 3. 启动连接
        con.start();
        // 4. 创建会话
        Session session = con.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标
        Destination dest = session.createQueue(QUEUE_NAME);
        // 6. 创建一个消费者
        MessageConsumer consumer = session.createConsumer(dest);
        // 7. 创建一个监听器
        consumer.setMessageListener((Message message) -> {
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
