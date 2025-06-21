package com.cn.train.member.service;

import com.cn.train.common.form.MemberTicketReq;
import com.cn.train.common.vo.PageResp;
import com.cn.train.member.dto.form.TicketQueryReq;
import com.cn.train.member.dto.vo.TicketQueryResp;

/**
 * @className: ITicketService
 * @author: wanyang
 * @date: 2025/6/21 19:03
 * @version: 1.0
 * @description: TODO
 */
public interface ITicketService {

    void save(MemberTicketReq req) throws Exception;

    PageResp<TicketQueryResp> queryList(TicketQueryReq req);

    void delete(Long id);
}
