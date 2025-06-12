package com.cn.train.common.controller;

import com.cn.train.common.exception.BusinessException;
import com.cn.train.common.vo.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult exceptionHandler(Exception e) {
        RestResult RestResult = new RestResult();
        LOG.error("系统异常：", e);
        RestResult.setSuccess(false);
        RestResult.setMessage("系统出现异常，请联系管理员");
        return RestResult;
    }

    /**
     * 业务异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public RestResult exceptionHandler(BusinessException e) {
        RestResult RestResult = new RestResult();
        LOG.error("业务异常：{}", e.getE().getDesc());
        RestResult.setSuccess(false);
        RestResult.setMessage(e.getE().getDesc());
        return RestResult;
    }

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public RestResult exceptionHandler(BindException e) {
        RestResult RestResult = new RestResult();
        LOG.error("校验异常：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        RestResult.setSuccess(false);
        RestResult.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return RestResult;
    }

}
