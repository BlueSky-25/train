package com.cn.train.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.cn.train.common.exception.BusinessException;
import com.cn.train.common.exception.BusinessExceptionEnum;
import com.cn.train.common.utils.JwtUtil;
import com.cn.train.common.utils.SnowUtil;
import com.cn.train.common.vo.MemberLoginResp;
import com.cn.train.member.domain.Member;
import com.cn.train.member.domain.MemberExample;
import com.cn.train.member.form.MemberLoginReq;
import com.cn.train.member.form.MemberSendCodeReq;
import com.cn.train.member.mapper.MemberMapper;
import com.cn.train.member.form.MemberRegisterReq;
import com.cn.train.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @className: MemberService
 * @author: wanyang
 * @date: 2025/6/12 11:42
 * @version: 1.0
 * @description: TODO
 */
@Service
public class MemberServiceImpl implements IMemberService {


    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Long register(MemberRegisterReq req) {
        Member member = getMember(req.getMobile());
        if (Objects.nonNull(member)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(req.getMobile());
        memberMapper.insert(member);
        return member.getId();
    }

    @Override
    public void sendCode(MemberSendCodeReq req) {
        Member member = getMember(req.getMobile());
        if (Objects.isNull(member)) {
            member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(req.getMobile());
            memberMapper.insert(member);
        }
        //生成验证码
        //String code = RandomUtil.randomString(4);
        String code = "1234";
        LOG.info("验证码 code = {}", code);
    }


    @Override
    public MemberLoginResp login(MemberLoginReq req) {
        Member member = getMember(req.getMobile());
        if (Objects.isNull(member)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        // 校验短信验证码
        if (!"1234".equals(req.getCode())) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }
        MemberLoginResp memberLoginResp = com.cn.train.member.mapstruct.MemberMapper.INSTANCE.memberLoginResp(member);
        String token = JwtUtil.createToken(memberLoginResp.getId(), memberLoginResp.getMobile());
        memberLoginResp.setToken(token);
        return memberLoginResp;
    }


    private Member getMember(String mobilePhone) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobilePhone);
        List<Member> members = memberMapper.selectByExample(memberExample);
        return CollectionUtil.isEmpty(members) ? null : members.get(0);
    }

}
