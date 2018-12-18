package com.net.vo;

import com.net.enumeration.UserIdentity;
import com.net.enumeration.UserState;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fjj
 * @date 2018/12/11 下午7:56
 */
public class UserVO implements Serializable {
    private Integer id;
    // 微信ID
    private String username;
    // 微信昵称
    private String nickname;
    // 用户真实姓名
    private String name;
    // 性（1：男   女：0）
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
    private UserState state = UserState.UNCHECKED;
    // 用户身份
    private UserIdentity identity = UserIdentity.USER;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
