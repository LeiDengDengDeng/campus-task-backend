package com.net.service;

import com.net.vo.ComplainVO;
import com.net.vo.ResponseVO;

/**
 * 投诉管理
 * Created by cong on 2018-12-05.
 */
public interface ComplainService {

    /**
     * 新建投诉
     * @param complainVO
     * @return
     */
    public ResponseVO addComplain(ComplainVO complainVO);

    /**
     * 查询投诉
     * @return
     */
    public ResponseVO getAllComplains();

}
