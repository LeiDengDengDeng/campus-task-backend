package com.net.vo;

import com.net.enumeration.TaskType;

import java.util.Date;

/**
 * Created by cong on 2018-12-05.
 */
public class TaskQueryVO {

    private TaskType type;

    private Integer paymentMin;

    private Integer paymentMax;

    //TODO


    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public Integer getPaymentMin() {
        return paymentMin;
    }

    public void setPaymentMin(Integer paymentMin) {
        this.paymentMin = paymentMin;
    }

    public Integer getPaymentMax() {
        return paymentMax;
    }

    public void setPaymentMax(Integer paymentMax) {
        this.paymentMax = paymentMax;
    }
}
