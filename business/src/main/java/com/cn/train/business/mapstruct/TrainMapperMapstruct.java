package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.Train;
import com.cn.train.business.dto.vo.TrainQueryResp;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @className: TrainMapper
 * @author: wanyang
 * @date: 2025/6/19 15:57
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainMapperMapstruct {

    TrainQueryResp train2QueryResp(Train train);

    List<TrainQueryResp> train2QueryRespList(List<Train> trains);
}
