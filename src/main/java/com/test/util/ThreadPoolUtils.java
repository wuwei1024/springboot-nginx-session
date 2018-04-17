package com.test.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wuwei
 * @date: 2018/4/8 11:16
 */

public class ThreadPoolUtils {

    private static final String lock1 = "lock1";
    private static final String lock2 = "lock2";

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(ThreadPoolUtils::test1);
            cachedThreadPool.execute(ThreadPoolUtils::test2);
        }
    }

    private static void test1() {
        synchronized (lock1) {
            System.out.println("test1: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000);
            } catch (Exception e) {

            }
        }
    }

    private static void test2() {
        synchronized (lock2) {
            System.out.println("test2: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000);
            } catch (Exception e) {

            }
        }
    }
}
