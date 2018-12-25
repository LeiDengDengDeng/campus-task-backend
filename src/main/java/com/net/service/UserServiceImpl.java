package com.net.service;
import com.net.enumeration.CoinChangeReason;

import com.net.enumeration.UserIdentity;
import com.net.enumeration.UserState;
import com.net.mapper.CoinRecordMapper;
import com.net.mapper.TaskMapper;
import com.net.mapper.UserMapper;
import com.net.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author fjj
 * @date 2018/12/11 下午8:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ResponseVO addUser(UserVO userVO) {
        try {
            UserVO userVO1 = userMapper.selectUserByAvatar(userVO.getAvatar());
            if(userVO1 != null){
                return ResponseVO.buildSuccess(userVO1);
            }
            userVO.setJoinDate(new Date());
            userVO.setState(UserState.UNCHECKED);
            userVO.setIdentity(UserIdentity.USER);
            userMapper.insertUser(userVO);

            //加积分
            CoinRecordVO coinRecordVO = new CoinRecordVO();
            coinRecordVO.setUserId(userVO.getId());
            coinRecordVO.setCount(10);
            coinRecordVO.setReason(CoinChangeReason.CHARGE);
            coinRecordVO.setTaskId(0);
            coinRecordVO.setTaskTitle("系统赠送");
            coinRecordVO.setAddTime(new Date());
            coinRecordMapper.insertCoinRecord(coinRecordVO);

            return ResponseVO.buildSuccess(userVO);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }

    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        try {
            userMapper.updateUserById(userVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUser(int id) {
        try {
            UserInfoVO userInfo = userMapper.selectUserInfoById(id);
            return ResponseVO.buildSuccess(userInfo);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getAllUsers() {
        try {
            List<UserVO> allUsers = userMapper.selectAllUsers();
            return ResponseVO.buildSuccess(allUsers);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUsersByState(String state) {
        try {
            List<UserVO> users = userMapper.selectUsersByState(state);
            return ResponseVO.buildSuccess(users);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getCoinsByUserId(int id) {
        try {
            List<CoinRecordVO> coins = coinRecordMapper.selectCoinRecords(id);
            return ResponseVO.buildSuccess(coins);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getPublicByUserId(int id) {
        try {
            List<TaskVO> tasks = taskMapper.selectByPublisher(id);
            return ResponseVO.buildSuccess(tasks);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getTakeByUserId(int id) {
        try {
            List<TaskVO> tasks = taskMapper.selectByTaker(id);
            return ResponseVO.buildSuccess(tasks);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUserByUsername(String username) {
        try {
            UserVO user = userMapper.selectUserByUsername(username);
            return ResponseVO.buildSuccess(user);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
