package com.cn.train.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @className: MemberApplication
 * @author: wanyang
 * @date: 2025/6/11 14:46
 * @version: 1.0
 * @description: MemberApplication 启动类
 */
@SpringBootApplication
public class GatewayApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GatewayApplication.class);
        ConfigurableEnvironment environment = application.run(args).getEnvironment();
        LOG.info("启动成功 --> {}", GatewayApplication.class.getName());
        LOG.info("地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
