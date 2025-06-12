package com.cn.train.member.controller;

import com.cn.train.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MemberController
 * @author: wanyang
 * @date: 2025/6/12 11:44
 * @version: 1.0
 * @description: TODO
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private IMemberService memberService;


}
