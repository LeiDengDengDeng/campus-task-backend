package com.net.vo;

import java.io.Serializable;

public class ComplainVO implements Serializable {
    private Integer id;

    private Integer taskId;

    private Integer publisher;

    private Integer orderTaker;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    public Integer getOrderTaker() {
        return orderTaker;
    }

    public void setOrderTaker(Integer orderTaker) {
        this.orderTaker = orderTaker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}