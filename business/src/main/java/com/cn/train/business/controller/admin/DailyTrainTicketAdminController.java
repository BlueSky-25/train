package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.DailyTrainTicketQueryReq;
import com.cn.train.business.dto.form.DailyTrainTicketSaveReq;
import com.cn.train.business.dto.vo.DailyTrainTicketQueryResp;
import com.cn.train.business.service.IDailyTrainTicketService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-ticket")
public class DailyTrainTicketAdminController {

    @Resource
    private IDailyTrainTicketService dailyTrainTicketService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody DailyTrainTicketSaveReq req) {
        dailyTrainTicketService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        dailyTrainTicketService.delete(id);
        return new RestResult<>();
    }

}
