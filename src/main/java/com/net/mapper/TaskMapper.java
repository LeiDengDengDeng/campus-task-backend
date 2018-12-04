package com.net.mapper;

import com.net.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    int insertSelective(TaskVO record);

    TaskVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskVO record);

}