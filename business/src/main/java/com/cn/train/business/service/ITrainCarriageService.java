package com.cn.train.business.service;

import com.cn.train.business.domain.TrainCarriage;
import com.cn.train.business.dto.form.TrainCarriageQueryReq;
import com.cn.train.business.dto.form.TrainCarriageSaveReq;
import com.cn.train.business.dto.vo.TrainCarriageQueryResp;
import com.cn.train.common.vo.PageResp;

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

    void save(TrainCarriageSaveReq req);

    PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req);

    void delete(Long id);
}
