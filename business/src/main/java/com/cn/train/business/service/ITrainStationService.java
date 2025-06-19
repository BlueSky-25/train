package com.cn.train.business.service;

import com.cn.train.business.domain.TrainStation;
import com.cn.train.business.dto.form.TrainStationQueryReq;
import com.cn.train.business.dto.form.TrainStationSaveReq;
import com.cn.train.business.dto.vo.TrainStationQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.List;

/**
 * @className: TrainStationService
 * @author: wanyang
 * @date: 2025/6/19 16:34
 * @version: 1.0
 * @description: TODO
 */
public interface ITrainStationService {

    void save(TrainStationSaveReq req);

    PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req);

    void delete(Long id);

    List<TrainStation> selectByTrainCode(String trainCode);
}
