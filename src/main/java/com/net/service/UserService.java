package com.net.service;

import com.net.vo.ResponseVO;
import com.net.vo.UserVO;

/**
 * @author fjj
 * @date 2018/12/11 下午8:01
 */
public interface UserService {

    /**
     * 添加一个用户
     * @param userVO
     * @return
     */
    ResponseVO addUser(UserVO userVO);

    /**
     * 更新用户信息
     * @param userVO
     * @return
     */
    ResponseVO updateUser(UserVO userVO);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    ResponseVO getUser(int id);
}
