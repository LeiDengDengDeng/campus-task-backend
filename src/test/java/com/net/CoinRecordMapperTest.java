package com.net;

import com.alibaba.fastjson.JSONObject;
import com.net.enumeration.CoinChangeReason;
import com.net.mapper.CoinRecordMapper;
import com.net.vo.CoinRecordVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinRecordMapperTest {

    @Autowired
    private CoinRecordMapper mapper;

    @Test
    public void selectCoin(){
        System.out.println(mapper.selectCoin(1));
    }

    @Test
    public void selectCoinRecords(){
        System.out.println(JSONObject.toJSONString(mapper.selectCoinRecords(1)));
    }

    @Test
    public void insertRecord(){
        CoinRecordVO recordVO=new CoinRecordVO();
        recordVO.setCount(2);
        recordVO.setReason(CoinChangeReason.CHARGE);
        recordVO.setUserId(1);
        mapper.insertCoinRecord(recordVO);
    }

}
