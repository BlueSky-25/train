package com.cn.train.business.controller.admin;


import com.cn.train.business.dto.form.TrainSeatQueryReq;
import com.cn.train.business.dto.form.TrainSeatQueryResp;
import com.cn.train.business.dto.form.TrainSeatSaveReq;
import com.cn.train.business.service.ITrainSeatService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-seat")
public class TrainSeatAdminController {

    @Resource
    private ITrainSeatService ITrainSeatService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody TrainSeatSaveReq req) {
        ITrainSeatService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<TrainSeatQueryResp>> queryList(@Valid TrainSeatQueryReq req) {
        PageResp<TrainSeatQueryResp> list = ITrainSeatService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        ITrainSeatService.delete(id);
        return new RestResult<>();
    }

}
