package com.cn.train.business.controller;

import com.cn.train.business.dto.form.SeatSellReq;
import com.cn.train.business.dto.vo.SeatSellResp;
import com.cn.train.business.service.IDailyTrainSeatService;
import com.cn.train.common.vo.RestResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

;

@RestController
@RequestMapping("/seat-sell")
public class SeatSellController {

    @Autowired
    private IDailyTrainSeatService dailyTrainSeatService;

    @GetMapping("/query")
    public RestResult<List<SeatSellResp>> query(@Valid SeatSellReq req) {
        List<SeatSellResp> seatList = dailyTrainSeatService.querySeatSell(req);
        return new RestResult<>(seatList);
    }

}
