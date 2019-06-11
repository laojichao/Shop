package com.glut.shop.application;


import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.HashMap;

import cn.bmob.v3.Bmob;

import static com.glut.shop.util.StaticClass.BMOB_APP_ID;

public class MainApplication extends Application {
    private static final String TAG = "MainApplication";
//    private String user_id = "123456"; // 当前用户的id
//    private String user_id = "123"; // 当前用户的id
    private String user_id = null; // 当前用户的id
    // 声明一个当前应用的静态实例
    private static MainApplication mApp;
    // 声明一个公共的信息映射对象，可当作全局变量使用
    public HashMap<String, String> mInfoMap = new HashMap<String, String>();

    // 利用单例模式获取当前应用的唯一实例
    public static MainApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        Bmob.initialize(this, BMOB_APP_ID);
        Log.d(TAG, "onCreate: 用户id:" + user_id);
        // 在打开应用时对静态的应用实例赋值
        mApp = this;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    // 声明一个公共的图标映射对象，
    public HashMap<Long, Bitmap> mIconMap = new HashMap<Long, Bitmap>();

}
