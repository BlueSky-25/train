package com.cn.train.business.controller;

import com.cn.train.business.dto.form.DailyTrainTicketQueryReq;
import com.cn.train.business.dto.vo.DailyTrainTicketQueryResp;
import com.cn.train.business.service.IDailyTrainTicketService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private IDailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new RestResult<>(list);
    }

}
