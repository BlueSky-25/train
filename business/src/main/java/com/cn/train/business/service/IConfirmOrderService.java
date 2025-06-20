package com.cn.train.business.service;

import com.cn.train.business.dto.form.ConfirmOrderDoReq;
import com.cn.train.business.dto.form.ConfirmOrderQueryReq;
import com.cn.train.business.dto.vo.ConfirmOrderQueryResp;
import com.cn.train.common.vo.PageResp;

/**
 * @className: IConfirmOrderService
 * @author: wanyang
 * @date: 2025/6/20 17:39
 * @version: 1.0
 * @description: TODO
 */
public interface IConfirmOrderService {

    void save(ConfirmOrderDoReq req);

    PageResp<ConfirmOrderQueryResp> queryList(ConfirmOrderQueryReq req);

    void delete(Long id);

    void doConfirm(ConfirmOrderDoReq req);
}
