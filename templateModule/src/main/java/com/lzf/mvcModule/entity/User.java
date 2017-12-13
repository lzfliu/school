package com.lzf.mvcModule.entity;

/**
 * Created by lzf on 2017/12/13.
 */
public class User {

    private String id;
    private String Name;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
