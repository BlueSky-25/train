package com.cn.train.batch.feign;

import com.cn.train.common.vo.RestResult;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BusinessFeignFallback implements BusinessFeign {
    @Override
    public String hello() {
        return "Fallback";
    }

    @Override
    public RestResult<Object> genDaily(Date date) {
        return null;
    }
}
