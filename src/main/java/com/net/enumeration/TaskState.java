package com.net.enumeration;

/**
 * Created by cong on 2018-12-04.
 */
public enum TaskState {
    /**
     * 接单未开始
     */
    UNSTART,
    /**
     * 等待接单
     */
    TO_TAKE_ORDER,
    /**
     * 已接单
     */
    ORDER_TAKED,
    /**
     * 已完成
     */
    FINISHED,
    /**
     * 发布人确认完成
     */
    FINISHED_CONFIRM,
    /**
     * 投诉中
     */
    COMPLAINING
}
