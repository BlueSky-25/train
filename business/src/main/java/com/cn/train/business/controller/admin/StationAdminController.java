package com.cn.train.business.controller.admin;


import com.cn.train.business.dto.form.StationQueryReq;
import com.cn.train.business.dto.form.StationSaveReq;
import com.cn.train.business.service.IStationService;
import com.cn.train.business.dto.vo.StationQueryResp;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/station")
public class StationAdminController {

    @Resource
    private IStationService IStationService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody StationSaveReq req) {
        IStationService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResp> list = IStationService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        IStationService.delete(id);
        return new RestResult<>();
    }

    @GetMapping("/query-all")
    public RestResult<List<StationQueryResp>> queryList() {
        List<StationQueryResp> list = IStationService.queryAll();
        return new RestResult<>(list);
    }

}
