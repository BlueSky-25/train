package com.cn.train.business.service;

import com.cn.train.business.domain.Train;
import com.cn.train.business.dto.form.DailyTrainQueryReq;
import com.cn.train.business.dto.form.DailyTrainSaveReq;
import com.cn.train.business.dto.vo.DailyTrainQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;

/**
 * @className: IDailyTrainService
 * @author: wanyang
 * @date: 2025/6/20 15:37
 * @version: 1.0
 * @description: TODO
 */
public interface IDailyTrainService {

    void save(DailyTrainSaveReq req);

    PageResp<DailyTrainQueryResp> queryList(DailyTrainQueryReq req);

    void delete(Long id);

    void genDaily(Date date);

    void genDailyTrain(Date date, Train train);
}
