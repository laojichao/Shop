package com.glut.shop;


import android.app.Application;
import android.util.Log;

public class MainApplication extends Application {
    private static final String TAG = "MainApplication";
    // 声明一个当前应用的静态实例
    private static MainApplication mApp;

    // 利用单例模式获取当前应用的唯一实例
    public static MainApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        // 在打开应用时对静态的应用实例赋值
        mApp = this;
    }

}
