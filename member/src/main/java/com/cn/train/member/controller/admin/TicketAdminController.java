package com.cn.train.member.controller.admin;

import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import com.cn.train.member.dto.form.TicketQueryReq;
import com.cn.train.member.dto.vo.TicketQueryResp;
import com.cn.train.member.service.ITicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/ticket")
public class TicketAdminController {

    @Resource
    private ITicketService ticketService;

    @GetMapping("/query-list")
    public RestResult<PageResp<TicketQueryResp>> queryList(@Valid TicketQueryReq req) {
        PageResp<TicketQueryResp> list = ticketService.queryList(req);
        return new RestResult<>(list);
    }

}
