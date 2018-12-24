package com.net;

import com.net.mapper.ComplainMapper;
import com.net.vo.ComplainVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplainMapperTest {

    @Autowired
    private ComplainMapper complainMapper;

    @Test
    public void addComplain(){
        ComplainVO complainVO=new ComplainVO();
        complainVO.setContent("xxx");
        complainVO.setOrderTaker(12);
        complainVO.setPublisher(11);
        complainVO.setTaskId(1);
        complainMapper.insertSelective(complainVO);
    }

}
