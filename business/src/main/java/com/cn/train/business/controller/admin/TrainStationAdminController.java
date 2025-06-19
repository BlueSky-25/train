package com.cn.train.business.controller.admin;


import com.cn.train.business.dto.form.TrainStationQueryReq;
import com.cn.train.business.dto.form.TrainStationSaveReq;
import com.cn.train.business.service.ITrainStationService;
import com.cn.train.business.dto.vo.TrainStationQueryResp;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-station")
public class TrainStationAdminController {

    @Resource
    private ITrainStationService trainStationService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody TrainStationSaveReq req) {
        trainStationService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<TrainStationQueryResp>> queryList(@Valid TrainStationQueryReq req) {
        PageResp<TrainStationQueryResp> list = trainStationService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        trainStationService.delete(id);
        return new RestResult<>();
    }

}
