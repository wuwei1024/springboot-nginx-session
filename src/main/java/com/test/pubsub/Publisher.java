package com.test.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wuwei
 * @date: 2018/3/23 15:41
 */
@Component
@EnableScheduling //开启定时器功能
public class Publisher {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private static final String MESSAGE = "当前时间：%s, 消息内容：%f";

    @Scheduled(initialDelay = 60 * 1000, fixedRate = 60 * 1000)
    public void sendMessage() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = String.format(MESSAGE, sdf.format(new Date()), Math.random());
        redisTemplate.convertAndSend("chat", msg);
    }
}
