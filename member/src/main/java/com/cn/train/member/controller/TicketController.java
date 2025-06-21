package com.cn.train.member.controller;

import com.cn.train.common.context.LoginMemberContext;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import com.cn.train.member.dto.form.TicketQueryReq;
import com.cn.train.member.dto.vo.TicketQueryResp;
import com.cn.train.member.service.ITicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/query-list")
    public RestResult<PageResp<TicketQueryResp>> query(@Valid TicketQueryReq req) {
        RestResult<PageResp<TicketQueryResp>> RestResult = new RestResult<>();
        req.setMemberId(LoginMemberContext.getId());
        PageResp<TicketQueryResp> pageResp = ticketService.queryList(req);
        RestResult.setContent(pageResp);
        return RestResult;
    }

}
