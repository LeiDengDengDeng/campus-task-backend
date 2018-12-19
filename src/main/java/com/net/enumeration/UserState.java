package com.net.enumeration;

/**
 * @author fjj
 * @date 2018/12/11 下午7:41
 */
public enum UserState {
    /**
     * 未审核
     */
    UNCHECKED,
    /**
     * 审核中
     */
    CHECKING,
    /**
     * 不通过
     */
    UNAPPROVED,
    /**
     * 已审核
     */
    CHECKED,
    /**
     * 封号
     */
    CLOSED
}
