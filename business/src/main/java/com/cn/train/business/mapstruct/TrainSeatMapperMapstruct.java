package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.TrainSeat;
import com.cn.train.business.dto.form.TrainSeatQueryResp;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @className: TrainSeatMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:21
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainSeatMapperMapstruct {

    TrainSeatQueryResp trainSeat2TrainSeatQueryResp(TrainSeat trainSeat);

    List<TrainSeatQueryResp> trainSeat2TrainSeatQueryRespList(List<TrainSeat> trainSeats);
}
