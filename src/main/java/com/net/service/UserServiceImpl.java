package com.net.service;

import com.net.mapper.UserMapper;
import com.net.vo.ResponseVO;
import com.net.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fjj
 * @date 2018/12/11 下午8:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO addUser(UserVO userVO) {
        try {
            userMapper.insertUser(userVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }

    }
}
