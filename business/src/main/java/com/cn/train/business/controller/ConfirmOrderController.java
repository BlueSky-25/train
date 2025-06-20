package com.cn.train.business.controller;


import com.cn.train.business.dto.form.ConfirmOrderDoReq;
import com.cn.train.business.service.IConfirmOrderService;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Resource
    private IConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public RestResult<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.doConfirm(req);
        return new RestResult<>();
    }

}
