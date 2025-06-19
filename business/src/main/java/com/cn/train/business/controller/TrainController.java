package com.cn.train.business.controller;

import com.cn.train.business.service.ITrainService;
import com.cn.train.business.dto.vo.TrainQueryResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private ITrainService ITrainService;

    @GetMapping("/query-all")
    public RestResult<List<TrainQueryResp>> queryList() {
        return new RestResult<>(ITrainService.queryAll());
    }

}
