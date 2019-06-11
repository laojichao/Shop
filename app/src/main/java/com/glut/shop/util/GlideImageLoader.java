package com.glut.shop.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;


/**
 * GlideImageLoader
 *  Describe:提供Banner图片加载器
 * @author lao
 * @date 2019/6/3
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .dontAnimate()
                .into(imageView);
    }
}
