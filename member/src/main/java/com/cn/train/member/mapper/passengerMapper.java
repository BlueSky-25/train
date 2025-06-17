package com.cn.train.member.mapper;

import com.cn.train.member.domain.passenger;
import com.cn.train.member.domain.passengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface passengerMapper {
    long countByExample(passengerExample example);

    int deleteByExample(passengerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(passenger record);

    int insertSelective(passenger record);

    List<passenger> selectByExample(passengerExample example);

    passenger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") passenger record, @Param("example") passengerExample example);

    int updateByExample(@Param("record") passenger record, @Param("example") passengerExample example);

    int updateByPrimaryKeySelective(passenger record);

    int updateByPrimaryKey(passenger record);
}