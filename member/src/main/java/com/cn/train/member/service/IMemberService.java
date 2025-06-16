package com.cn.train.member.service;

import com.cn.train.common.vo.MemberLoginResp;
import com.cn.train.member.form.MemberLoginReq;
import com.cn.train.member.form.MemberRegisterReq;
import com.cn.train.member.form.MemberSendCodeReq;

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

    /**
     * 发送验证码
     * @param req
     * @return
     */
    void sendCode(MemberSendCodeReq req);

    /**
     * 登录
     * @param req
     * @return
     */
    MemberLoginResp login(MemberLoginReq req);
}
