package com.glut.shop.bean;

import cn.bmob.v3.BmobObject;

/**
 * 时间 ：  2019/6/6      10:41
 * 创建人：  Ahel
 * 包名：   com.glut.shop.bean
 * 类名：   Person
 * 功能：    TODO
 * 主要方法：
 */
public class Person extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}