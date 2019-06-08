package com.glut.shop.bean;

import retrofit2.http.PUT;

/**
 * CartInfo
 *
 * @author lao
 * @date 2019/6/7
 */

public class CartInfo {
    private long rowid;      //行号
    private int xuhao;       //列好
    private String goods_id;     //商品id
    private String shop;         //店铺名字
    private String title;        //商品标题
    private float price;         //价格
    private int count;
    private String image;
    private String update_time;

    public long getRowid() {
        return rowid;
    }

    public void setRowid(long rowid) {
        this.rowid = rowid;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public CartInfo(){
        rowid = 0L;
        xuhao = 0;
        goods_id = "";
        shop = "";
        title = "";
        price = 0f;
        count = 0;
        image = "";
    }
}
