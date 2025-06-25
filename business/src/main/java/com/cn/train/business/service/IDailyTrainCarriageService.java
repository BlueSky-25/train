package com.cn.train.business.service;

import com.cn.train.business.domain.DailyTrainCarriage;
import com.cn.train.business.dto.form.DailyTrainCarriageQueryReq;
import com.cn.train.business.dto.form.DailyTrainCarriageSaveReq;
import com.cn.train.business.dto.vo.DailyTrainCarriageQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;
import java.util.List;

/**
 * @className: IDailyTrainCarriageService
 * @author: wanyang
 * @date: 2025/6/20 15:40
 * @version: 1.0
 * @description: TODO
 */
public interface IDailyTrainCarriageService {

    void save(DailyTrainCarriageSaveReq req);

    PageResp<DailyTrainCarriageQueryResp> queryList(DailyTrainCarriageQueryReq req);

    void genDaily(Date date, String trainCode);

    void delete(Long id);

    List<DailyTrainCarriage> selectBySeatType(Date date, String trainCode, String seatType);

}
