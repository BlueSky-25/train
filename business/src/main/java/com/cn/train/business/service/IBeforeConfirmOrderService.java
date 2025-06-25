package com.cn.train.business.service;

import com.cn.train.business.dto.form.ConfirmOrderDoReq;

/**
 * @className: IBeforeConfirmOrderService
 * @author: wanyang
 * @date: 2025/6/22 18:32
 * @version: 1.0
 * @description: TODO
 */
public interface IBeforeConfirmOrderService {

    Long beforeDoConfirm(ConfirmOrderDoReq req);
}
