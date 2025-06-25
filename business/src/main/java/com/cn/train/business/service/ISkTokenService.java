package com.cn.train.business.service;

import com.cn.train.business.dto.form.SkTokenQueryReq;
import com.cn.train.business.dto.form.SkTokenSaveReq;
import com.cn.train.business.dto.vo.SkTokenQueryResp;
import com.cn.train.common.vo.PageResp;

import java.util.Date;

/**
 * @className: ISkTokenService
 * @author: wanyang
 * @date: 2025/6/25 13:42
 * @version: 1.0
 * @description: TODO
 */
public interface ISkTokenService {

    void save(SkTokenSaveReq req);

    PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);

    boolean validSkToken(Date date, String trainCode, Long id);
}
