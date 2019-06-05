package com.glut.shop.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by chenzhijian on 2016/2/16.
 */
public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示Toast
     */
    public static void showToast(Context context, CharSequence text) {
//        if(mToast == null) {
//            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//        } else {
//            mToast.setText(text);
//            mToast.setDuration(Toast.LENGTH_SHORT);
//        }
//        mToast.show();
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}