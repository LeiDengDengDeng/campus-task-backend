package com.net.vo;

import com.net.enumeration.UserIdentity;
import com.net.enumeration.UserState;

import java.util.Date;

/**
 * @author fjj
 * @date 2018/12/12 下午7:47
 */
public class UserInfoVO {
    private Integer id;
    // 用户名
    private String username;
    // 用户真实姓名
    private String name;
    // 性别
    private Integer gender;
    // 微信头像地址
    private String avatar;
    // 上传的认证照片的地址
    private String pictureUrl;
    // 第一次登录小程序的时间
    private Date joinDate;
    // 电话
    private String phone;
    // 用户账号状态
    private UserState state;
    // 用户身份
    private UserIdentity identity;

    // 平均评分
    private double comment_star;
    // 发单数
    private int publish_times;
    // 接单数
    private int take_times;
    // 积分
    private int coins;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(UserIdentity identity) {
        this.identity = identity;
    }

    public double getComment_star() {
        return comment_star;
    }

    public void setComment_star(double comment_star) {
        this.comment_star = comment_star;
    }

    public int getPublish_times() {
        return publish_times;
    }

    public void setPublish_times(int publish_times) {
        this.publish_times = publish_times;
    }

    public int getTake_times() {
        return take_times;
    }

    public void setTake_times(int take_times) {
        this.take_times = take_times;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
