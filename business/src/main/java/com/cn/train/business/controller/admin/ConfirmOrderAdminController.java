package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.ConfirmOrderDoReq;
import com.cn.train.business.dto.form.ConfirmOrderQueryReq;
import com.cn.train.business.dto.vo.ConfirmOrderQueryResp;
import com.cn.train.business.service.IConfirmOrderService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/confirm-order")
public class ConfirmOrderAdminController {

    @Resource
    private IConfirmOrderService confirmOrderService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<ConfirmOrderQueryResp>> queryList(@Valid ConfirmOrderQueryReq req) {
        PageResp<ConfirmOrderQueryResp> list = confirmOrderService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        confirmOrderService.delete(id);
        return new RestResult<>();
    }

}
