package com.lzf.entity;

public class User {
    private Integer id;

    private String username;

    private String age;

    private String sex;

    public User(Integer id, String username, String age, String sex) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public User() {
        super();
    }

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
        this.username = username == null ? null : username.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}