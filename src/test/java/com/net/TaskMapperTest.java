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
        taskVO.setCommentContent("ccccccccccccccccc");
        taskVO.setCommentStar(4);
        taskVO.setContent("hhhhhhhhhhhhhhh");
        taskVO.setEnd(new Date());
        taskVO.setOrderTaker(1);
        taskVO.setPayment(1200);
        taskVO.setPictureUrl("http://llll");
        taskVO.setPublisher(2);
        taskVO.setStart(new Date());
        taskVO.setTitle("xxxxxxx");
        taskVO.setState(TaskState.FINISHED_CONFIRM);
        taskVO.setType(TaskType.OTHER);
        mapper.insertSelective(taskVO);
    }

    @Test
    public void selectById(){
        System.out.println(JSONObject.toJSONString(mapper.selectByPrimaryKey(1)));
    }

    @Test
    public void updateById(){
        TaskVO taskVO=new TaskVO();
        taskVO.setId(1);
        taskVO.setTitle("bbbbbbbbbbbbbb");
        taskVO.setPictureUrl("hhhhhhhh");
        taskVO.setCommentStar(2);
        mapper.updateByPrimaryKeySelective(taskVO);
    }

}
