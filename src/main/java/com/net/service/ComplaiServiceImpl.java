package com.net.service;

import com.net.mapper.ComplainMapper;
import com.net.vo.ComplainVO;
import com.net.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2018-12-12.
 */
@Service
public class ComplaiServiceImpl implements ComplainService{

    @Autowired
    private ComplainMapper complainMapper;

    @Override
    public ResponseVO addComplain(ComplainVO complainVO) {
        complainMapper.insertSelective(complainVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getAllComplains() {
        return ResponseVO.buildSuccess(complainMapper.selectAllComplain());
    }
}
