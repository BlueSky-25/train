package com.cn.train.business.service;

import com.cn.train.business.dto.form.StationQueryReq;
import com.cn.train.business.dto.form.StationSaveReq;
import com.cn.train.business.dto.vo.StationQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.List;

/**
 * @className: StationService
 * @author: wanyang
 * @date: 2025/6/19 16:24
 * @version: 1.0
 * @description: TODO
 */
public interface IStationService {

    void save(StationSaveReq req);

    PageResp<StationQueryResp> queryList(StationQueryReq req);

    void delete(Long id);

    List<StationQueryResp> queryAll();
}
