package com.cn.train.business.service;

import com.cn.train.business.domain.TrainCarriage;

import java.util.List;

/**
 * @className: TrainCarriageService
 * @author: wanyang
 * @date: 2025/6/19 15:17
 * @version: 1.0
 * @description: TODO
 */
public interface ITrainCarriageService {

    List<TrainCarriage> selectByTrainCode(String trainCode);
}
