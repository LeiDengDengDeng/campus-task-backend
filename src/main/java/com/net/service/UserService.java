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

    /**
     * 查询所有用户
     * @return
     */
    ResponseVO getAllUsers();

    /**
     * 通过状态查询用户
     * @param state
     * @return
     */
    ResponseVO getUsersByState(String state);

    /**
     * 根据id查找用户积分详情
     * @param id
     * @return
     */
    ResponseVO getCoinsByUserId(int id);

    /**
     * 根据id查找发单详情
     * @param id
     * @return
     */
    ResponseVO getPublicByUserId(int id);

    /**
     * 根据id查找接单详情
     * @param id
     * @return
     */
    ResponseVO getTakeByUserId(int id);
}
