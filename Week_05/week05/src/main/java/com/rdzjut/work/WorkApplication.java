package com.rdzjut.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理
@EnableCaching // 开启缓存
@EnableScheduling
public class WorkApplication {
    //class09和hikari测试详见测试类WorkApplicationTests
    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);
    }
}
