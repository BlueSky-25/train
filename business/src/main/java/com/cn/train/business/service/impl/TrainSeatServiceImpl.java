package com.cn.train.business.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.cn.train.business.domain.TrainCarriage;
import com.cn.train.business.domain.TrainSeat;
import com.cn.train.business.domain.TrainSeatExample;
import com.cn.train.business.enums.SeatColEnum;
import com.cn.train.business.dto.form.TrainSeatQueryReq;
import com.cn.train.business.dto.form.TrainSeatQueryResp;
import com.cn.train.business.dto.form.TrainSeatSaveReq;
import com.cn.train.business.mapper.TrainSeatMapper;
import com.cn.train.business.mapstruct.TrainSeatMapperMapstruct;
import com.cn.train.business.mapstruct.TrainSeatSaveReqMapperMapstruct;
import com.cn.train.business.service.ITrainCarriageService;
import com.cn.train.business.service.ITrainSeatService;
import com.cn.train.common.utils.SnowUtil;
import com.cn.train.common.vo.PageResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className: TrainSeatServiceImpl
 * @author: wanyang
 * @date: 2025/6/19 15:16
 * @version: 1.0
 * @description: TODO
 */
@Service
public class TrainSeatServiceImpl implements ITrainSeatService {

    private static final Logger LOG = LoggerFactory.getLogger(ITrainSeatService.class);

    @Resource
    private TrainSeatMapper trainSeatMapper;

    @Resource
    private ITrainCarriageService trainCarriageService;

    @Resource
    private TrainSeatMapperMapstruct trainSeatMapperMapstruct;

    @Resource
    private TrainSeatSaveReqMapperMapstruct trainSeatSaveReqMapperMapstruct;

    @Override
    public void save(TrainSeatSaveReq req) {
        DateTime now = DateTime.now();
        TrainSeat trainSeat = trainSeatSaveReqMapperMapstruct.TrainSeatSaveReq2TrainSeat(req);
        if (ObjectUtil.isNull(trainSeat.getId())) {
            trainSeat.setId(SnowUtil.getSnowflakeNextId());
            trainSeat.setCreateTime(now);
            trainSeat.setUpdateTime(now);
            trainSeatMapper.insert(trainSeat);
        } else {
            trainSeat.setUpdateTime(now);
            trainSeatMapper.updateByPrimaryKey(trainSeat);
        }
    }

    @Override
    public PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.setOrderByClause("train_code asc, carriage_index asc, carriage_seat_index asc");
        TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();
        if (ObjectUtil.isNotEmpty(req.getTrainCode())) {
            criteria.andTrainCodeEqualTo(req.getTrainCode());
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<TrainSeat> trainSeatList = trainSeatMapper.selectByExample(trainSeatExample);

        PageInfo<TrainSeat> pageInfo = new PageInfo<>(trainSeatList);
        List<TrainSeatQueryResp> list = trainSeatMapperMapstruct.trainSeat2TrainSeatQueryRespList(trainSeatList);

        PageResp<TrainSeatQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    @Override
    public void delete(Long id) {
        trainSeatMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void genTrainSeat(String trainCode) {
        DateTime now = DateTime.now();
        // 清空当前车次下的所有的座位记录
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();
        criteria.andTrainCodeEqualTo(trainCode);
        trainSeatMapper.deleteByExample(trainSeatExample);

        // 查找当前车次下的所有的车厢
        List<TrainCarriage> carriageList = trainCarriageService.selectByTrainCode(trainCode);
        LOG.info("当前车次下的车厢数：{}", carriageList.size());

        // 循环生成每个车厢的座位
        for (TrainCarriage trainCarriage : carriageList) {
            // 拿到车厢数据：行数、座位类型(得到列数)
            Integer rowCount = trainCarriage.getRowCount();
            String seatType = trainCarriage.getSeatType();
            int seatIndex = 1;

            // 根据车厢的座位类型，筛选出所有的列，比如车箱类型是一等座，则筛选出columnList={ACDF}
            List<SeatColEnum> colEnumList = SeatColEnum.getColsByType(seatType);
            LOG.info("根据车厢的座位类型，筛选出所有的列：{}", colEnumList);

            // 循环行数
            for (int row = 1; row <= rowCount; row++) {
                // 循环列数
                for (SeatColEnum seatColEnum : colEnumList) {
                    // 构造座位数据并保存数据库
                    TrainSeat trainSeat = new TrainSeat();
                    trainSeat.setId(SnowUtil.getSnowflakeNextId());
                    trainSeat.setTrainCode(trainCode);
                    trainSeat.setCarriageIndex(trainCarriage.getIndex());
                    trainSeat.setRow(StrUtil.fillBefore(String.valueOf(row), '0', 2));
                    trainSeat.setCol(seatColEnum.getCode());
                    trainSeat.setSeatType(seatType);
                    trainSeat.setCarriageSeatIndex(seatIndex++);
                    trainSeat.setCreateTime(now);
                    trainSeat.setUpdateTime(now);
                    trainSeatMapper.insert(trainSeat);
                }
            }
        }
    }

    @Override
    public List<TrainSeat> selectByTrainCode(String trainCode) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.setOrderByClause("`id` asc");
        TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();
        criteria.andTrainCodeEqualTo(trainCode);
        return trainSeatMapper.selectByExample(trainSeatExample);
    }
}
