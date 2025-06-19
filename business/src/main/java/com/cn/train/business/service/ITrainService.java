package com.cn.train.business.service;

import com.cn.train.business.domain.Train;
import com.cn.train.business.dto.form.TrainQueryReq;
import com.cn.train.business.dto.form.TrainSaveReq;
import com.cn.train.business.dto.vo.TrainQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.List;

/**
 * @className: TrainService
 * @author: wanyang
 * @date: 2025/6/19 15:11
 * @version: 1.0
 * @description: TODO
 */
public interface ITrainService {

    void save(TrainSaveReq req);

    Train selectByUnique(String code);

    PageResp<TrainQueryResp> queryList(TrainQueryReq req);

    void delete(Long id);

    List<TrainQueryResp> queryAll();

    List<Train> selectAll();
}
