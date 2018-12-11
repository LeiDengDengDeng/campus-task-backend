package com.net.mapper;

import com.net.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fjj
 * @date 2018/12/11 下午7:54
 */

@Mapper
public interface UserMapper {
    int insertUser(UserVO user);
}
