package com.cn.train.business.service;

import com.cn.train.business.domain.TrainSeat;
import com.cn.train.business.dto.form.TrainSeatQueryReq;
import com.cn.train.business.dto.form.TrainSeatQueryResp;
import com.cn.train.business.dto.form.TrainSeatSaveReq;
import com.cn.train.common.vo.PageResp;

import java.util.List;

/**
 * @className: TrainSeatService
 * @author: wanyang
 * @date: 2025/6/19 15:16
 * @version: 1.0
 * @description: TODO
 */
public interface ITrainSeatService {

    void save(TrainSeatSaveReq req);

    PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req);

    void delete(Long id);

    void genTrainSeat(String trainCode);

    List<TrainSeat> selectByTrainCode(String trainCode);
}
