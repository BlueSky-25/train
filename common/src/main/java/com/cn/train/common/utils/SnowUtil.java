package com.cn.train.common.utils;

import cn.hutool.core.util.IdUtil;

/**
 * 封装hutool雪花算法
 */
public class SnowUtil {
    /*

    0       -    00000000 00000000 00000000 00000000 00000000 0 - 00000000 00       - 00000000 0000
    1bit 不用 -   41bit  时间戳                   -                 10bit 工作机器id   -   12bit序列号
     */

    // 分布式的情况下， 可以使用一个 中间件 获取唯一值
    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    // 时钟回拨问题： 暂时不启动这个服务器..



    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}
