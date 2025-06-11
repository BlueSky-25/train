package com.cn.train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @author: wanyang
 * @date: 2025/6/11 14:26
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello(){
        return "Hello World11222";
    }

}
