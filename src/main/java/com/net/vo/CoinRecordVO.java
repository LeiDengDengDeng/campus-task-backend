package com.net.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.net.enumeration.CoinChangeReason;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 积分变动记录
 * Created by cong on 2018-12-12.
 */
public class CoinRecordVO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 变动数额
     */
    private int count;

    /**
     * 变动原因
     */
    private CoinChangeReason reason;

    /**
     * 相关的任务id
     */
    private int taskId;

    /**
     * 相关的任务标题
     */
    private String taskTitle="";

    /**
     * 发生的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date addTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CoinChangeReason getReason() {
        return reason;
    }

    public void setReason(CoinChangeReason reason) {
        this.reason = reason;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
