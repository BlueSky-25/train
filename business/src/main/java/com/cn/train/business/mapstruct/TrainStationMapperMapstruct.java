package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.TrainStation;
import com.cn.train.business.dto.vo.TrainStationQueryResp;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @className: TrainStationMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:43
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainStationMapperMapstruct {

    TrainStationQueryResp TrainStation2TrainStationQueryResp(TrainStation trainStation);

    List<TrainStationQueryResp> TrainStation2TrainStationQueryRespList(List<TrainStation> trainStations);
}
