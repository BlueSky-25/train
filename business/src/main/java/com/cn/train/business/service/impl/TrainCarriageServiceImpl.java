package com.cn.train.business.service.impl;

import com.cn.train.business.domain.TrainCarriage;
import com.cn.train.business.domain.TrainCarriageExample;
import com.cn.train.business.mapper.TrainCarriageMapper;
import com.cn.train.business.service.ITrainCarriageService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: TrainCarriageServiceImpl
 * @author: wanyang
 * @date: 2025/6/19 15:17
 * @version: 1.0
 * @description: TODO
 */
@Service
public class TrainCarriageServiceImpl implements ITrainCarriageService {

    private static final Logger LOG = LoggerFactory.getLogger(ITrainCarriageService.class);

    @Resource
    private TrainCarriageMapper trainCarriageMapper;

    @Override
    public List<TrainCarriage> selectByTrainCode(String trainCode) {
        TrainCarriageExample trainCarriageExample = new TrainCarriageExample();
        trainCarriageExample.setOrderByClause("`index` asc");
        TrainCarriageExample.Criteria criteria = trainCarriageExample.createCriteria();
        criteria.andTrainCodeEqualTo(trainCode);
        return trainCarriageMapper.selectByExample(trainCarriageExample);
    }
}
