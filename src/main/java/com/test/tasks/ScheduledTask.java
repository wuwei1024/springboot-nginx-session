package com.test.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: wuwei
 * @date: 2018/4/1 12:10
 */
@Component
public class ScheduledTask {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private SetOperations<String, String> setOperations;

    @PostConstruct
    public void getDataOperations() {
        setOperations = redisTemplate.opsForSet();
    }

    //可变长度线程池
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static Logger logger = Logger.getLogger(ScheduledTask.class.getName());

    //@Scheduled(fixedDelay = 3000)
    public void test() {
        cachedThreadPool.execute(this::test1);
        cachedThreadPool.execute(this::test2);
        cachedThreadPool.execute(this::test3);
    }

    public void test1() {
        try {
            String currentThreadName = Thread.currentThread().getName();
            setOperations.add("test1:threadNames", currentThreadName);
            //logger.log(Level.INFO, "[test1方法当前线程名称]: " + currentThreadName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void test2() {
        try {
            String currentThreadName = Thread.currentThread().getName();
            setOperations.add("test2:threadNames", currentThreadName);
            //logger.log(Level.INFO, "[test2方法当前线程名称]: " + currentThreadName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void test3() {
        try {
            String currentThreadName = Thread.currentThread().getName();
            setOperations.add("test3:threadNames", currentThreadName);
            //logger.log(Level.INFO, "[test3方法当前线程名称]: " + currentThreadName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
}
