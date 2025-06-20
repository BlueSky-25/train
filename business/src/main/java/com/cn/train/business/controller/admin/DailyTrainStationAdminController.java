package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.DailyTrainStationQueryReq;
import com.cn.train.business.dto.form.DailyTrainStationSaveReq;
import com.cn.train.business.dto.vo.DailyTrainStationQueryResp;
import com.cn.train.business.service.IDailyTrainStationService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-station")
public class DailyTrainStationAdminController {

    @Resource
    private IDailyTrainStationService dailyTrainStationService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody DailyTrainStationSaveReq req) {
        dailyTrainStationService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainStationQueryResp>> queryList(@Valid DailyTrainStationQueryReq req) {
        PageResp<DailyTrainStationQueryResp> list = dailyTrainStationService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        dailyTrainStationService.delete(id);
        return new RestResult<>();
    }

}
