package com.lzf.webservice.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzf on 2017/12/20.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5939599230753662529L;
    private String userId;
    private String username;
    private String age;
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
