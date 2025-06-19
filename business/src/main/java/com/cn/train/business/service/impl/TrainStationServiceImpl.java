package com.cn.train.business.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.cn.train.business.domain.TrainStation;
import com.cn.train.business.domain.TrainStationExample;
import com.cn.train.business.dto.form.TrainStationQueryReq;
import com.cn.train.business.dto.form.TrainStationSaveReq;
import com.cn.train.business.mapper.TrainStationMapper;
import com.cn.train.business.mapstruct.TrainStationMapperMapstruct;
import com.cn.train.business.mapstruct.TrainStationSaveReqMapperMapstruct;
import com.cn.train.business.service.ITrainStationService;
import com.cn.train.business.dto.vo.TrainStationQueryResp;
import com.cn.train.common.exception.BusinessException;
import com.cn.train.common.exception.BusinessExceptionEnum;
import com.cn.train.common.utils.SnowUtil;
import com.cn.train.common.vo.PageResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: TrainStationServiceImpl
 * @author: wanyang
 * @date: 2025/6/19 16:34
 * @version: 1.0
 * @description: TODO
 */
@Service
public class TrainStationServiceImpl implements ITrainStationService {

    private static final Logger LOG = LoggerFactory.getLogger(ITrainStationService.class);

    @Resource
    private TrainStationMapper trainStationMapper;

    @Resource
    private TrainStationSaveReqMapperMapstruct trainStationSaveReqMapperMapstruct;

    @Resource
    private TrainStationMapperMapstruct trainStationMapperMapstruct;

    @Override
    public void save(TrainStationSaveReq req) {
        DateTime now = DateTime.now();
        TrainStation trainStation = trainStationSaveReqMapperMapstruct.TrainStationSaveReq2TrainStation(req);
        if (ObjectUtil.isNull(trainStation.getId())) {

            // 保存之前，先校验唯一键是否存在
            TrainStation trainStationDB = selectByUnique(req.getTrainCode(), req.getIndex());
            if (ObjectUtil.isNotEmpty(trainStationDB)) {
                throw new BusinessException(BusinessExceptionEnum.BUSINESS_TRAIN_STATION_INDEX_UNIQUE_ERROR);
            }
            // 保存之前，先校验唯一键是否存在
            trainStationDB = selectByUnique(req.getTrainCode(), req.getName());
            if (ObjectUtil.isNotEmpty(trainStationDB)) {
                throw new BusinessException(BusinessExceptionEnum.BUSINESS_TRAIN_STATION_NAME_UNIQUE_ERROR);
            }

            trainStation.setId(SnowUtil.getSnowflakeNextId());
            trainStation.setCreateTime(now);
            trainStation.setUpdateTime(now);
            trainStationMapper.insert(trainStation);
        } else {
            trainStation.setUpdateTime(now);
            trainStationMapper.updateByPrimaryKey(trainStation);
        }
    }

    private TrainStation selectByUnique(String trainCode, Integer index) {
        TrainStationExample trainStationExample = new TrainStationExample();
        trainStationExample.createCriteria()
                .andTrainCodeEqualTo(trainCode)
                .andIndexEqualTo(index);
        List<TrainStation> list = trainStationMapper.selectByExample(trainStationExample);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    private TrainStation selectByUnique(String trainCode, String name) {
        TrainStationExample trainStationExample = new TrainStationExample();
        trainStationExample.createCriteria()
                .andTrainCodeEqualTo(trainCode)
                .andNameEqualTo(name);
        List<TrainStation> list = trainStationMapper.selectByExample(trainStationExample);
        return CollUtil.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req) {
        TrainStationExample trainStationExample = new TrainStationExample();
        trainStationExample.setOrderByClause("train_code asc, `index` asc");
        TrainStationExample.Criteria criteria = trainStationExample.createCriteria();
        if (ObjectUtil.isNotEmpty(req.getTrainCode())) {
            criteria.andTrainCodeEqualTo(req.getTrainCode());
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<TrainStation> trainStationList = trainStationMapper.selectByExample(trainStationExample);
        PageInfo<TrainStation> pageInfo = new PageInfo<>(trainStationList);
        List<TrainStationQueryResp> list = trainStationMapperMapstruct.TrainStation2TrainStationQueryRespList(trainStationList);
        PageResp<TrainStationQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    @Override
    public void delete(Long id) {
        trainStationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TrainStation> selectByTrainCode(String trainCode) {
        TrainStationExample trainStationExample = new TrainStationExample();
        trainStationExample.setOrderByClause("`index` asc");
        trainStationExample.createCriteria().andTrainCodeEqualTo(trainCode);
        return trainStationMapper.selectByExample(trainStationExample);
    }
}
