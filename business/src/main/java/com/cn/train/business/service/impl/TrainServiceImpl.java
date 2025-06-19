package com.cn.train.business.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.cn.train.business.domain.Train;
import com.cn.train.business.domain.TrainExample;
import com.cn.train.business.dto.form.TrainQueryReq;
import com.cn.train.business.dto.form.TrainSaveReq;
import com.cn.train.business.mapper.TrainMapper;
import com.cn.train.business.mapstruct.TrainMapperMapstruct;
import com.cn.train.business.mapstruct.TrainSaveReqMapperMapstruct;
import com.cn.train.business.service.ITrainService;
import com.cn.train.business.dto.vo.TrainQueryResp;
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
 * @className: TrainServiceImpl
 * @author: wanyang
 * @date: 2025/6/19 15:11
 * @version: 1.0
 * @description: TODO
 */
@Service
public class TrainServiceImpl implements ITrainService {

    private static final Logger LOG = LoggerFactory.getLogger(ITrainService.class);

    @Resource
    private TrainMapper trainMapper;

    @Resource
    private TrainSaveReqMapperMapstruct trainSaveReqMapperMapstruct;

    @Resource
    private TrainMapperMapstruct trainMapperMapstruct;

    @Override
    public void save(TrainSaveReq req) {
        DateTime now = DateTime.now();
        Train train = trainSaveReqMapperMapstruct.TrainSaveReq2Train(req);
        if (ObjectUtil.isNull(train.getId())) {

            // 保存之前，先校验唯一键是否存在
            Train trainDB = selectByUnique(req.getCode());
            if (ObjectUtil.isNotEmpty(trainDB)) {
                throw new BusinessException(BusinessExceptionEnum.BUSINESS_TRAIN_CODE_UNIQUE_ERROR);
            }

            train.setId(SnowUtil.getSnowflakeNextId());
            train.setCreateTime(now);
            train.setUpdateTime(now);
            trainMapper.insert(train);
        } else {
            train.setUpdateTime(now);
            trainMapper.updateByPrimaryKey(train);
        }
    }

    @Override
    public Train selectByUnique(String code) {
        TrainExample trainExample = new TrainExample();
        trainExample.createCriteria()
                .andCodeEqualTo(code);
        List<Train> list = trainMapper.selectByExample(trainExample);
        return CollUtil.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public PageResp<TrainQueryResp> queryList(TrainQueryReq req) {
        TrainExample trainExample = new TrainExample();
        trainExample.setOrderByClause("code asc");
        TrainExample.Criteria criteria = trainExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Train> trainList = trainMapper.selectByExample(trainExample);
        PageInfo<Train> pageInfo = new PageInfo<>(trainList);
        List<TrainQueryResp> list = trainMapperMapstruct.train2QueryRespList(trainList);

        PageResp<TrainQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    @Override
    public void delete(Long id) {
        trainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TrainQueryResp> queryAll() {
        List<Train> trainList = selectAll();
        return trainMapperMapstruct.train2QueryRespList(trainList);
    }

    @Override
    public List<Train> selectAll() {
        TrainExample trainExample = new TrainExample();
        trainExample.setOrderByClause("code asc");
        return trainMapper.selectByExample(trainExample);
    }
}
