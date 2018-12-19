package com.net;

import com.alibaba.fastjson.JSONObject;
import com.net.enumeration.TaskState;
import com.net.enumeration.TaskType;
import com.net.mapper.TaskMapper;
import com.net.vo.TaskVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by cong on 2018-12-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper mapper;

    @Test
    public void insert(){
        TaskVO taskVO=new TaskVO();
        taskVO.setContent("hhhhhhhhhhhhhhh");

        taskVO.setOrderTaker(2);
        taskVO.setPayment(60);
        taskVO.setPublisher(1);
        taskVO.setStart(new Date());
        taskVO.setTitle("xxxxxxx");
        taskVO.setState(TaskState.TO_TAKE_ORDER);
        taskVO.setType(TaskType.OTHER);
        taskVO.setPublisherIconUrl("http");
        mapper.insertSelective(taskVO);
    }

    @Test
    public void selectById(){
        System.out.println(JSONObject.toJSONString(mapper.selectByPrimaryKey(27)));
    }

    @Test
    public void updateById(){
        TaskVO taskVO=new TaskVO();
        taskVO.setId(40);
        taskVO.setOrderTaker(1);
        mapper.updateByPrimaryKeySelective(taskVO);
    }

    @Test
    public void select(){

    }

    @Test
    public void selectByUser(){
        System.out.println(JSONObject.toJSONString(mapper.selectByPublisher(2)));
        System.out.println(JSONObject.toJSONString(mapper.selectByTaker(1)));
    }

}
