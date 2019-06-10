package com.glut.shop.bean;

/**
 * HistoryInfo
 *
 * @author lao
 * @date 2019/6/10
 */
public class HistoryInfo {
    private long rowid;
    private int xuhao;
    private String user_id;
    private String goods_id;
    private String title;
    private float price;
    private String image;
    private String update_time;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    private boolean select;

    public long getRowid() {
        return rowid;
    }

    public void setRowid(long rowid) {
        this.rowid = rowid;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
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

    public HistoryInfo() {
        rowid = 0L;
        xuhao = 0;
        user_id = null;
        goods_id = "";
        title = "";
        price = 0f;
        image = "";
        update_time = "";
        select = false;
    }

}
