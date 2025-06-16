package com.cn.train.member.mapstruct;

import com.cn.train.common.vo.MemberLoginResp;
import com.cn.train.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @className: MemberMapper
 * @author: wanyang
 * @date: 2025/6/16 15:20
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberLoginResp memberLoginResp(Member member);
}
