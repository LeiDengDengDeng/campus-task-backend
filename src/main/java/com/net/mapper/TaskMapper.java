package com.net.mapper;

import com.net.vo.TaskQueryVO;
import com.net.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    int insertSelective(TaskVO record);

    TaskVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskVO record);

    List<TaskVO> selectByPublisher(Integer publisherId);

    List<TaskVO> selectByTaker(Integer taker);

    List<TaskVO> select(TaskQueryVO queryVO);
}