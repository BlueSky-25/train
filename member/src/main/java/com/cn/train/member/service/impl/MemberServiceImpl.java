package com.cn.train.member.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.cn.train.common.exception.BusinessException;
import com.cn.train.common.exception.BusinessExceptionEnum;
import com.cn.train.common.utils.SnowUtil;
import com.cn.train.member.domain.Member;
import com.cn.train.member.domain.MemberExample;
import com.cn.train.member.mapper.MemberMapper;
import com.cn.train.member.form.MemberRegisterReq;
import com.cn.train.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Long register(MemberRegisterReq req) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(req.getMobile());
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (CollectionUtil.isNotEmpty(members)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(req.getMobile());
        memberMapper.insert(member);
        return member.getId();
    }

}
