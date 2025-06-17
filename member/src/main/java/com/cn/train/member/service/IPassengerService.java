package com.cn.train.member.service;

import com.cn.train.common.vo.PageResp;
import com.cn.train.member.form.PassengerQueryReq;
import com.cn.train.member.form.PassengerSaveReq;
import com.cn.train.member.vo.PassengerQueryResp;

import java.util.List;

/**
 * @className: PassengerService
 * @author: wanyang
 * @date: 2025/6/17 14:48
 * @version: 1.0
 * @description: TODO
 */
public interface IPassengerService {

    void save(PassengerSaveReq req);

    PageResp<PassengerQueryResp> queryList(PassengerQueryReq req);

    void delete(Long id);

    List<PassengerQueryResp> queryMine();
}
