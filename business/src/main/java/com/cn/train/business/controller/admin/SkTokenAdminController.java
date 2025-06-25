package com.cn.train.business.controller.admin;

import com.cn.train.business.dto.form.SkTokenQueryReq;
import com.cn.train.business.dto.form.SkTokenSaveReq;
import com.cn.train.business.dto.vo.SkTokenQueryResp;
import com.cn.train.business.service.ISkTokenService;
import com.cn.train.common.vo.PageResp;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sk-token")
public class SkTokenAdminController {

    @Resource
    private ISkTokenService skTokenService;

    @PostMapping("/save")
    public RestResult<Object> save(@Valid @RequestBody SkTokenSaveReq req) {
        skTokenService.save(req);
        return new RestResult<>();
    }

    @GetMapping("/query-list")
    public RestResult<PageResp<SkTokenQueryResp>> queryList(@Valid SkTokenQueryReq req) {
        PageResp<SkTokenQueryResp> list = skTokenService.queryList(req);
        return new RestResult<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult<Object> delete(@PathVariable Long id) {
        skTokenService.delete(id);
        return new RestResult<>();
    }

}
