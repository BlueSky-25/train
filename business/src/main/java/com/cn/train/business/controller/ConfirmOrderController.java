package com.cn.train.business.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.train.business.dto.form.ConfirmOrderDoReq;
import com.cn.train.business.service.IBeforeConfirmOrderService;
import com.cn.train.business.service.IConfirmOrderService;
import com.cn.train.common.exception.BusinessExceptionEnum;
import com.cn.train.common.vo.RestResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Resource
    private IBeforeConfirmOrderService beforeConfirmOrderService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private IConfirmOrderService confirmOrderService;

    @Value("${spring.profiles.active}")
    private String env;

    @SentinelResource(value = "confirmOrderDo", blockHandler = "doConfirmBlock")
    @PostMapping("/do")
    public RestResult<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        if (!env.equals("dev")) {
            // 图形验证码校验
            String imageCodeToken = req.getImageCodeToken();
            String imageCode = req.getImageCode();
            String imageCodeRedis = redisTemplate.opsForValue().get(imageCodeToken);
            if (ObjectUtils.isEmpty(imageCodeRedis)) {
                return new RestResult<>(false, "验证码已过期", null);
            }
            // 验证码校验，大小写忽略，提升体验，比如Oo Vv Ww容易混
            if (!imageCodeRedis.equalsIgnoreCase(imageCode)) {
                return new RestResult<>(false, "验证码不正确", null);
            } else {
                // 验证通过后，移除验证码
                redisTemplate.delete(imageCodeToken);
            }
        }

        Long id = beforeConfirmOrderService.beforeDoConfirm(req);
        return new RestResult<>(String.valueOf(id));
    }

    @GetMapping("/cancel/{id}")
    public RestResult<Integer> cancel(@PathVariable Long id) {
        Integer count = confirmOrderService.cancel(id);
        return new RestResult<>(count);
    }


    /** 降级方法，需包含限流方法的所有参数和BlockException参数，且返回值要保持一致
     * @param req
     * @param e
     */
    public RestResult<Object> doConfirmBlock(ConfirmOrderDoReq req, BlockException e) {
        // throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION);
        RestResult<Object> restResult = new RestResult<>();
        restResult.setSuccess(false);
        restResult.setMessage(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION.getDesc());
        return restResult;

    }
}
