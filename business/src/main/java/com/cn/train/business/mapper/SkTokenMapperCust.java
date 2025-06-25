package com.cn.train.business.mapper;

import java.util.Date;

public interface SkTokenMapperCust {

    int decrease(Date date, String trainCode, int decreaseCount);
}
