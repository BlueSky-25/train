package com.cn.train.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @className: BatchApplication
 * @author: wanyang
 * @date: 2025/6/12 12:47
 * @version: 1.0
 * @description: 启动类
 */
@SpringBootApplication(scanBasePackages = {"com.cn.train.common", "com.cn.train.batch"})
@EnableFeignClients("com.cn.train.batch.feign")
public class BatchApplication {

    private static final Logger LOG = LoggerFactory.getLogger(BatchApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BatchApplication.class);
        ConfigurableEnvironment environment = application.run(args).getEnvironment();
        LOG.info("启动成功 --> {}", BatchApplication.class.getName());
        LOG.info("地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
