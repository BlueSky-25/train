package com.cn.train.business.service;

import com.cn.train.business.domain.DailyTrain;
import com.cn.train.business.domain.DailyTrainTicket;
import com.cn.train.business.dto.form.DailyTrainTicketQueryReq;
import com.cn.train.business.dto.form.DailyTrainTicketSaveReq;
import com.cn.train.business.dto.vo.DailyTrainTicketQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;

/**
 * @className: IDailyTrainTicketService
 * @author: wanyang
 * @date: 2025/6/20 15:43
 * @version: 1.0
 * @description: TODO
 */
public interface IDailyTrainTicketService {

    void save(DailyTrainTicketSaveReq req);

    PageResp<DailyTrainTicketQueryResp> queryList(DailyTrainTicketQueryReq req);

    void delete(Long id);

    void genDaily(DailyTrain dailyTrain, Date date, String trainCode);

    DailyTrainTicket selectByUnique(Date date, String trainCode, String start, String end);
}
