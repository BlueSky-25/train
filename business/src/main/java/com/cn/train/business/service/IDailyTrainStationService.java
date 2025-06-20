package com.cn.train.business.service;

import com.cn.train.business.dto.form.DailyTrainStationQueryReq;
import com.cn.train.business.dto.form.DailyTrainStationSaveReq;
import com.cn.train.business.dto.vo.DailyTrainStationQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;

/**
 * @className: IDailyTrainStationService
 * @author: wanyang
 * @date: 2025/6/20 15:44
 * @version: 1.0
 * @description: TODO
 */
public interface IDailyTrainStationService {

    void save(DailyTrainStationSaveReq req);

    PageResp<DailyTrainStationQueryResp> queryList(DailyTrainStationQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);
}
