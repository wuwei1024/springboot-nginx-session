package com.test.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 生产者
 *
 * @author: wuwei
 * @date: 2018/4/23 17:50
 */

public class Producer {
    private final static String URL = "tcp://localhost:61616";
    /**
     * 中间件队列名
     * 参考：https://blog.csdn.net/zcl_love_wx/article/details/78406416
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
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标
        Destination dest = session.createQueue(QUEUE_NAME);
        // 6. 创建一个生产者
        MessageProducer pro = session.createProducer(dest);
        for (int i = 0; i < 10; i++) {
            // 7. 创建消息
            TextMessage msg = session.createTextMessage("消息" + i);
            // 8. 发布消息
            pro.send(msg);
            System.out.println(msg);
        }
        // 9. 关闭连接
        con.close();
    }
}
