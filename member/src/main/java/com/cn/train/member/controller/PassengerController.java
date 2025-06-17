package com.cn.train.member.controller;

import com.cn.train.common.context.LoginMemberContext;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import com.cn.train.member.form.PassengerQueryReq;
import com.cn.train.member.form.PassengerSaveReq;
import com.cn.train.member.service.IPassengerService;
import com.cn.train.member.vo.PassengerQueryResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: PassengerController
 * @author: wanyang
 * @date: 2025/6/17 14:58
 * @version: 1.0
 * @description: TODO
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private IPassengerService passengerService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new RestResult<>();
    }


    @GetMapping("/query-list")
    public RestResult<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        passengerService.delete(id);
        return new RestResult<>();
    }

    @GetMapping("/queryMine")
    public RestResult<List<PassengerQueryResp>> queryMine() {
        List<PassengerQueryResp> list = passengerService.queryMine();
        return new RestResult<>(list);
    }
}
