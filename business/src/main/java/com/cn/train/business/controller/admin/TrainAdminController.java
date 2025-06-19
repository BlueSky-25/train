package com.cn.train.business.controller.admin;


import com.cn.train.business.dto.form.TrainQueryReq;
import com.cn.train.business.dto.form.TrainSaveReq;
import com.cn.train.business.service.ITrainSeatService;
import com.cn.train.business.service.ITrainService;
import com.cn.train.business.dto.vo.TrainQueryResp;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

    @Resource
    private ITrainService ITrainService;

    @Resource
    private ITrainSeatService ITrainSeatService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody TrainSaveReq req) {
        ITrainService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResp> list = ITrainService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        ITrainService.delete(id);
        return new RestResult<>();
    }

    @GetMapping("/query-all")
    public RestResult<List<TrainQueryResp>> queryList() {
        List<TrainQueryResp> list = ITrainService.queryAll();
        return new RestResult<>(list);
    }

    @GetMapping("/gen-seat/{trainCode}")
    public RestResult<Object> genSeat(@PathVariable String trainCode) {
        ITrainSeatService.genTrainSeat(trainCode);
        return new RestResult<>();
    }

}
