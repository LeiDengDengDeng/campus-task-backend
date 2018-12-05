package com.net.vo;

/**
 * Created by cong on 2018-12-05.
 */
public class CommentVO {

    /**
     * 评论的任务
     */
    private Integer taskId;

    /**
     * 星级
     * 1-5
     */
    private Integer star;

    /**
     * 评论内容
     */
    private String content;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
