package com.glut.shop.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * GoodsInfo
 *
 * @author lao
 * @date 2019/6/7
 */

public class GoodsInfo {
    private String id;       //商品id
    private String shop;    //店铺名
    private String price;    //价格
    private String title;    //标题
    private List<String> spec;   //规格
    private String feature1;     //特征
    private String feature2;
    private List<String> img;    //图片

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSpec() {
        return spec;
    }

    public void setSpec(List<String> spec) {
        this.spec = spec;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }


    public GoodsInfo() {
        id = "";
        price = "";
        title = "";
        spec = new ArrayList<>();
        feature1 = "";
        feature2 = "";
        img = new ArrayList<>();
    }
}
