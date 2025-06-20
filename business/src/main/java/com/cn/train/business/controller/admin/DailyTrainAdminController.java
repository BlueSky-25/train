package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.DailyTrainQueryReq;
import com.cn.train.business.dto.form.DailyTrainSaveReq;
import com.cn.train.business.dto.vo.DailyTrainQueryResp;
import com.cn.train.business.service.IDailyTrainService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private IDailyTrainService dailyTrainService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new RestResult<>();
    }

    @GetMapping("/gen-daily/{date}")
    public RestResult<Object> genDaily(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        dailyTrainService.genDaily(date);
        return new RestResult<>();
    }

}
