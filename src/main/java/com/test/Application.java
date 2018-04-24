package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: wuwei
 * @date: 2018/4/1 12:07
 */
@SpringBootApplication
@EnableScheduling
@EnableJms
public class Application {//用自带tomcat部署

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//@SpringBootApplication
//@EnableScheduling
//public class Application extends SpringBootServletInitializer {//用外部tomcat部署
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(Application.class);
//    }
//}
