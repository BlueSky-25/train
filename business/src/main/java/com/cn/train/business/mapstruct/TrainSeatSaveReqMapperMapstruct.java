package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.TrainSeat;
import com.cn.train.business.dto.form.TrainSeatSaveReq;
import org.mapstruct.Mapper;

/**
 * @className: TrainSeatSaveReqMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:23
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainSeatSaveReqMapperMapstruct {

    TrainSeat TrainSeatSaveReq2TrainSeat(TrainSeatSaveReq req);
}
