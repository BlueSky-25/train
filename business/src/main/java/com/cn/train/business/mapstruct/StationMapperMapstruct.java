package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.Station;
import com.cn.train.business.dto.vo.StationQueryResp;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @className: StationMapperMapstruct
 * @author: wanyang
 * @date: 2025/6/19 16:28
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface StationMapperMapstruct {

    StationQueryResp station2StationQueryResp(Station station);

    List<StationQueryResp> station2StationQueryRespList(List<Station> stations);
}
