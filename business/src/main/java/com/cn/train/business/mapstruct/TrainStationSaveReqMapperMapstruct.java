package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.TrainStation;
import com.cn.train.business.dto.form.TrainStationSaveReq;
import org.mapstruct.Mapper;

/**
 * @className: TrainStationSaveReqMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:42
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainStationSaveReqMapperMapstruct {
    TrainStation TrainStationSaveReq2TrainStation(TrainStationSaveReq req);
}
