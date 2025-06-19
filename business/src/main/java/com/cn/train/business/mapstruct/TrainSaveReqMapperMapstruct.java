package com.cn.train.business.mapstruct;

import com.cn.train.business.domain.Train;
import com.cn.train.business.dto.form.TrainSaveReq;
import org.mapstruct.Mapper;

/**
 * @className: TrainSaveReqMapper
 * @author: wanyang
 * @date: 2025/6/19 15:50
 * @version: 1.0
 * @description: TODO
 */
@Mapper(componentModel = "spring")
public interface TrainSaveReqMapperMapstruct {

    Train TrainSaveReq2Train(TrainSaveReq req);
}
