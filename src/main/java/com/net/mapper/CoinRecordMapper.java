package com.net.mapper;

import com.net.vo.CoinRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cong on 2018-12-12.
 */
@Mapper
public interface CoinRecordMapper {

    public Integer selectCoin(Integer userId);

    public List<CoinRecordVO> selectCoinRecords(Integer userId);

    public void insertCoinRecord(CoinRecordVO coinRecordVO);

}
