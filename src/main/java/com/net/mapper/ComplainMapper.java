package com.net.mapper;

import com.net.vo.ComplainVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComplainMapper {
    int insertSelective(ComplainVO record);
}