package com.cn.train.business.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.cn.train.business.domain.Station;
import com.cn.train.business.domain.StationExample;
import com.cn.train.business.dto.form.StationQueryReq;
import com.cn.train.business.dto.form.StationSaveReq;
import com.cn.train.business.mapper.StationMapper;
import com.cn.train.business.mapstruct.StationMapperMapstruct;
import com.cn.train.business.mapstruct.StationSaveReqMapperMapstruct;
import com.cn.train.business.service.IStationService;
import com.cn.train.business.dto.vo.StationQueryResp;
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
 * @className: StationServiceImpl
 * @author: wanyang
 * @date: 2025/6/19 16:24
 * @version: 1.0
 * @description: TODO
 */
@Service
public class StationServiceImpl implements IStationService {

    private static final Logger LOG = LoggerFactory.getLogger(IStationService.class);

    @Resource
    private StationMapper stationMapper;

    @Resource
    private StationSaveReqMapperMapstruct stationSaveReqMapperMapstruct;

    @Resource
    private StationMapperMapstruct stationMapperMapstruct;

    @Override
    public void save(StationSaveReq req) {
        DateTime now = DateTime.now();
        Station station = stationSaveReqMapperMapstruct.stationSaveReq2Station(req);
        if (ObjectUtil.isNull(station.getId())) {

            // 保存之前，先校验唯一键是否存在
            Station stationDB = selectByUnique(req.getName());
            if (ObjectUtil.isNotEmpty(stationDB)) {
                throw new BusinessException(BusinessExceptionEnum.BUSINESS_STATION_NAME_UNIQUE_ERROR);
            }

            station.setId(SnowUtil.getSnowflakeNextId());
            station.setCreateTime(now);
            station.setUpdateTime(now);
            stationMapper.insert(station);
        } else {
            station.setUpdateTime(now);
            stationMapper.updateByPrimaryKey(station);
        }
    }


    private Station selectByUnique(String name) {
        StationExample stationExample = new StationExample();
        stationExample.createCriteria().andNameEqualTo(name);
        List<Station> list = stationMapper.selectByExample(stationExample);
        return CollUtil.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public PageResp<StationQueryResp> queryList(StationQueryReq req) {
        StationExample stationExample = new StationExample();
        stationExample.setOrderByClause("id desc");
        StationExample.Criteria criteria = stationExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Station> stationList = stationMapper.selectByExample(stationExample);
        PageInfo<Station> pageInfo = new PageInfo<>(stationList);
        List<StationQueryResp> list = stationMapperMapstruct.station2StationQueryRespList(stationList);
        PageResp<StationQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void delete(Long id) {
        stationMapper.deleteByPrimaryKey(id);
    }

    public List<StationQueryResp> queryAll() {
        StationExample stationExample = new StationExample();
        stationExample.setOrderByClause("name_pinyin asc");
        List<Station> stationList = stationMapper.selectByExample(stationExample);
        return stationMapperMapstruct.station2StationQueryRespList(stationList);
    }
}
