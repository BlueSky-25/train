package com.cn.train.business;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @className: BusinessApplication
 * @author: wanyang
 * @date: 2025/6/19 14:47
 * @version: 1.0
 * @description: TODO
 */
@SpringBootApplication(scanBasePackages = {"com.cn.train.common", "com.cn.train.business"})
@MapperScan("com.cn.train.business.mapper")
@EnableFeignClients("com.cn.train.business.feign")
@EnableCaching
@EnableAsync
public class BusinessApplication {

    private static final Logger LOG = LoggerFactory.getLogger(BusinessApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BusinessApplication.class);
        ConfigurableEnvironment environment = application.run(args).getEnvironment();
        LOG.info("启动成功 --> {}", BusinessApplication.class.getName());
        LOG.info("地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
