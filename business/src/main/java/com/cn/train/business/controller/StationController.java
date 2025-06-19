package com.cn.train.business.controller;

import com.cn.train.business.service.IStationService;
import com.cn.train.business.dto.vo.StationQueryResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Resource
    private IStationService IStationService;

    @GetMapping("/query-all")
    public RestResult<List<StationQueryResp>> queryList() {
        List<StationQueryResp> list = IStationService.queryAll();
        return new RestResult<>(list);
    }

}
