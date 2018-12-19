package com.net.vo;

import java.util.List;

/**
 * Created by cong on 2018-12-17.
 */
public class TaskShowVO {

    private List<TaskVO> tasks;

    private UserInfoVO userVO;

    public List<TaskVO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskVO> tasks) {
        this.tasks = tasks;
    }

    public UserInfoVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserInfoVO userVO) {
        this.userVO = userVO;
    }
}
