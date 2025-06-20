package com.cn.train.business.feign;

import com.cn.train.common.form.MemberTicketReq;
import com.cn.train.common.vo.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

 @FeignClient("member")
//@FeignClient(name = "member", url = "http://127.0.0.1:8001")
public interface MemberFeign {

    @GetMapping("/member/feign/ticket/save")
    RestResult<Object> save(@RequestBody MemberTicketReq req);

}
