package com.cn.train.batch.feign;

import com.cn.train.common.vo.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "member")
public interface MemberFeign {


}
