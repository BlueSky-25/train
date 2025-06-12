package com.cn.train.member.service.impl;

import com.cn.train.member.mapper.MemberMapper;
import com.cn.train.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @className: MemberService
 * @author: wanyang
 * @date: 2025/6/12 11:42
 * @version: 1.0
 * @description: TODO
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private MemberMapper memberMapper;

}
