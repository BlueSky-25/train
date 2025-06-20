package com.cn.train.business.controller.admin;


import com.cn.train.business.dto.form.DailyTrainCarriageQueryReq;
import com.cn.train.business.dto.form.DailyTrainCarriageSaveReq;
import com.cn.train.business.dto.vo.DailyTrainCarriageQueryResp;
import com.cn.train.business.service.IDailyTrainCarriageService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-carriage")
public class DailyTrainCarriageAdminController {

    @Resource
    private IDailyTrainCarriageService dailyTrainCarriageService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody DailyTrainCarriageSaveReq req) {
        dailyTrainCarriageService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainCarriageQueryResp>> queryList(@Valid DailyTrainCarriageQueryReq req) {
        PageResp<DailyTrainCarriageQueryResp> list = dailyTrainCarriageService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        dailyTrainCarriageService.delete(id);
        return new RestResult<>();
    }

}
