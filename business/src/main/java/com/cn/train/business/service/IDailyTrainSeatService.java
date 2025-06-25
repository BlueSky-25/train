package com.cn.train.business.service;

import com.cn.train.business.domain.DailyTrainSeat;
import com.cn.train.business.dto.form.DailyTrainSeatQueryReq;
import com.cn.train.business.dto.form.DailyTrainSeatSaveReq;
import com.cn.train.business.dto.form.SeatSellReq;
import com.cn.train.business.dto.vo.DailyTrainSeatQueryResp;
import com.cn.train.business.dto.vo.SeatSellResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;
import java.util.List;

/**
 * @className: IDailyTrainSeatService
 * @author: wanyang
 * @date: 2025/6/20 15:43
 * @version: 1.0
 * @description: TODO
 */
public interface IDailyTrainSeatService {

    void save(DailyTrainSeatSaveReq req);

    PageResp<DailyTrainSeatQueryResp> queryList(DailyTrainSeatQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);

    int countSeat(Date date, String trainCode);

    int countSeat(Date date, String trainCode, String seatType);

    List<DailyTrainSeat> selectByCarriage(Date date, String trainCode, Integer index);

    List<SeatSellResp> querySeatSell(SeatSellReq req);

}
