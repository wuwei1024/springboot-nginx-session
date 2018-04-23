package com.test.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
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
    private ValueOperations<String, String> valueOperations;
    private ListOperations<String, String> listOperations;
    private HashOperations<String, String, String> hashOperations;
    private SetOperations<String, String> setOperations;
    private ZSetOperations<String, String> zSetOperations;

    //可变长度线程池
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static Logger logger = Logger.getLogger(ScheduledTask.class.getName());
    private static final String LOCK_1 = "lock1";
    private static final String LOCK_2 = "lock2";
    private static final String LOCK_3 = "lock2";

    @PostConstruct
    public void getRedisOperations() {
        valueOperations = redisTemplate.opsForValue();
        listOperations = redisTemplate.opsForList();
        hashOperations = redisTemplate.opsForHash();
        setOperations = redisTemplate.opsForSet();
        zSetOperations = redisTemplate.opsForZSet();
    }

    @Scheduled(fixedDelay = 3000)
    public void test() {
        cachedThreadPool.execute(this::test1);
        cachedThreadPool.execute(this::test2);
        cachedThreadPool.execute(this::test3);
    }

    public void test1() {
        synchronized (LOCK_1) {
            try {
                String currentThreadName = Thread.currentThread().getName();
                zSetOperations.add("test1:threadNames", currentThreadName, System.currentTimeMillis());
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
    }

    public void test2() {
        synchronized (LOCK_2) {
            try {
                String currentThreadName = Thread.currentThread().getName();
                zSetOperations.add("test2:threadNames", currentThreadName, System.currentTimeMillis());
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
    }

    public void test3() {
        synchronized (LOCK_3) {
            try {
                String currentThreadName = Thread.currentThread().getName();
                zSetOperations.add("test3:threadNames", currentThreadName, System.currentTimeMillis());
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
    }
}
