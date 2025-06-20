package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.DailyTrainSeatQueryReq;
import com.cn.train.business.dto.form.DailyTrainSeatSaveReq;
import com.cn.train.business.dto.vo.DailyTrainSeatQueryResp;
import com.cn.train.business.service.IDailyTrainSeatService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-seat")
public class DailyTrainSeatAdminController {

    @Resource
    private IDailyTrainSeatService dailyTrainSeatService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody DailyTrainSeatSaveReq req) {
        dailyTrainSeatService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainSeatQueryResp>> queryList(@Valid DailyTrainSeatQueryReq req) {
        PageResp<DailyTrainSeatQueryResp> list = dailyTrainSeatService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        dailyTrainSeatService.delete(id);
        return new RestResult<>();
    }

}
