package com.cn.train.business.service;

import com.cn.train.business.domain.ConfirmOrder;
import com.cn.train.business.domain.DailyTrainSeat;
import com.cn.train.business.domain.DailyTrainTicket;
import com.cn.train.business.dto.form.ConfirmOrderTicketReq;

import java.util.List;

/**
 * @className: AfterConfirmOrderService
 * @author: wanyang
 * @date: 2025/6/20 17:52
 * @version: 1.0
 * @description: TODO
 */
public interface IAfterConfirmOrderService {

    void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> finalSeatList, List<ConfirmOrderTicketReq> tickets, ConfirmOrder confirmOrder);

}
