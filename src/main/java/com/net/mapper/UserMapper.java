package com.net.mapper;

import com.net.enumeration.UserState;
import com.net.vo.UserInfoVO;
import com.net.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fjj
 * @date 2018/12/11 下午7:54
 */

@Mapper
public interface UserMapper {
    int insertUser(UserVO user);

    int updateUserById(UserVO userVO);

    UserInfoVO selectUserInfoById(int id);

    List<UserVO> selectAllUsers();

    List<UserVO> selectUsersByState(String state);

    UserVO selectUserByUsername(String username);

    UserVO selectUserByAvatar(String avatar);
}
