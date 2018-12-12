package com.net.mapper;

import com.net.vo.ComplainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplainMapper {
    int insertSelective(ComplainVO record);

    List<ComplainVO> selectAllComplain();

}