package com.glut.shop.bean;

import cn.bmob.v3.BmobUser;

/**
 * 时间 ：  2019/6/6      16:37
 * 创建人：  Ahel
 * 包名：   com.glut.shop.bean
 * 类名：   User
 * 功能：    TODO
 * 主要方法：
 */
public class User extends BmobUser {
    private int age;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;


}
