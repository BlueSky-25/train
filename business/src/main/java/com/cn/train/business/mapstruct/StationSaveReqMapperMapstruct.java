package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.Station;
import com.cn.train.business.dto.form.StationSaveReq;
import org.mapstruct.Mapper;

/**
 * @className: StationSaveReqMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:27
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface StationSaveReqMapperMapstruct {

    Station stationSaveReq2Station(StationSaveReq req);
}
