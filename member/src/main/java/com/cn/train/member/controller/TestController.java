package com.cn.train.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @author: wanyang
 * @date: 2025/6/11 16:01
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
