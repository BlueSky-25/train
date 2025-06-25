package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.TrainCarriageQueryReq;
import com.cn.train.business.dto.form.TrainCarriageSaveReq;
import com.cn.train.business.dto.vo.TrainCarriageQueryResp;
import com.cn.train.business.service.ITrainCarriageService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-carriage")
public class TrainCarriageAdminController {

    @Resource
    private ITrainCarriageService trainCarriageService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody TrainCarriageSaveReq req) {
        trainCarriageService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<TrainCarriageQueryResp>> queryList(@Valid TrainCarriageQueryReq req) {
        PageResp<TrainCarriageQueryResp> list = trainCarriageService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        trainCarriageService.delete(id);
        return new RestResult<>();
    }

}
