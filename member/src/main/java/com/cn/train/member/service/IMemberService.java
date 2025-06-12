package com.cn.train.member.service;

import com.cn.train.member.form.MemberRegisterReq;

/**
 * @className: MemberService
 * @author: wanyang
 * @date: 2025/6/12 11:42
 * @version: 1.0
 * @description: TODO
 */
public interface IMemberService {

    /**
     * 注册
     * @param req
     * @return
     */
    Long register(MemberRegisterReq req);
}
