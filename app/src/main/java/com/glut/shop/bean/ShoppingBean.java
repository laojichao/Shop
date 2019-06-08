package com.glut.shop.bean;

import java.io.Serializable;
import java.util.List;

/**
 * CartBean
 *
 * @author lao
 * @date 2019/5/30
 */
public class ShoppingBean implements Serializable {


    /**
     * status : true
     * msg :
     * data : [{"store_name":"泊爱电脑手机","user_id":"2997","store_id":"15036517189924090000","list":[{"goods_price":2798,"cart_id":"15206697631223840000","member_id":"15167082162510250000","goods_id":"15157284674419540000","goods_num":"1","goods_name":"vivo X9s Plus 全网通 4GB+64GB","goods_image":"http://img.lion-mall.com/goods/20180112/f1ce79c40e7a16caef3d551e87cbd54f.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"黑 4+64全网通","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15157284674402800000"},{"goods_price":1499,"cart_id":"15206697301518310000","member_id":"15167082162510250000","goods_id":"15153949350638380000","goods_num":"5","goods_name":"华为手机NOVA 青春全网4-64G","goods_image":"http://img.lion-mall.com/goods/20180108/96ca747aeaffacc6b75be3f1b72827f0.png","spec_desc":"","spec1_name":"颜色","spec1_value":"蓝色","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15153949350627100000"},{"goods_price":11288,"cart_id":"15206693537135720000","member_id":"15167082162510250000","goods_id":"15157396518144480000","goods_num":"5","goods_name":" Apple MacBook Pro 13.3英寸笔记本电脑","goods_image":"http://img.lion-mall.com/goods/20180112/3c058df9cdb3c1e7ce786bbdc0186b39.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"银 新MACBOOK PRO-13寸I5-2.3/8-256GB","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15157396518138430000"}]},{"store_name":"芷兰堂 葩丽","user_id":"93","store_id":"14823227483019680000","list":[{"goods_price":32,"cart_id":"15206696136941370000","member_id":"15167082162510250000","goods_id":"15152137458906360000","goods_num":"1","goods_name":"葩丽 力度威高档内衣生物洗衣液","goods_image":"http://img.lion-mall.com/goods/20180106/a1895fe57a33502b676949cfbfbd2da1.jpg","spec_desc":"","spec1_name":"经典装","spec1_value":"1000ml(积分价)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":13,"is_have_point":"1","model_id":"15152137458897290000"}]},{"store_name":"智能生活屋","user_id":"3090","store_id":"15110923292896270000","list":[{"goods_price":31.9,"cart_id":"15206693816469060000","member_id":"15167082162510250000","goods_id":"15172947866705000000","goods_num":"3","goods_name":"杜酷2.4g无线鼠标 办公鼠标 笔记本鼠标 MS302","goods_image":"http://img.lion-mall.com/goods/20180130/b160167b294c58ab46b7af21c14cc21e.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"宝石蓝(积分兑)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":8,"is_have_point":"1","model_id":"15172947866684640000"},{"goods_price":98,"cart_id":"15206693711146970000","member_id":"15167082162510250000","goods_id":"15154810744773360000","goods_num":"12","goods_name":"杜酷（DUKU） 无线蓝牙键盘多屏双通道蓝牙键盘通用","goods_image":"http://img.lion-mall.com/goods/20180109/8885a44d743b75ccb0f3601686ddb719.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"黑色(积分价)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":31,"is_have_point":"1","model_id":"15154810744751190000"}]},{"store_name":"缘礼贸易","user_id":"1124","store_id":"14880295292959680000","list":[{"goods_price":136,"cart_id":"15206693401010410000","member_id":"15167082162510250000","goods_id":"15166069210426020000","goods_num":"15","goods_name":"联创DF-EP2019M尊致电热水壶2L","goods_image":"http://img.lion-mall.com/goods/20180122/59db553319485bd32b067742aff4d3c2.png","spec_desc":"","spec1_name":"颜色","spec1_value":"图片色(积分兑)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":89,"is_have_point":"1","model_id":"15166069210414950000"}]},{"store_name":"微超优品","user_id":"229","store_id":"14828331510902860000","list":[{"goods_price":63,"cart_id":"15206693220350690000","member_id":"15167082162510250000","goods_id":"15162477971822670000","goods_num":"8","goods_name":"飞科剃须刀FS829电动刮胡刀双刀头旋转式胡须刀","goods_image":"http://img.lion-mall.com/goods/20180118/52d39fb875525387d0eddce11e843fb3.jpg","spec_desc":"","spec1_name":"型号","spec1_value":"FS829(积分价)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":16,"is_have_point":"1","model_id":"15162477971812280000"},{"goods_price":5165,"cart_id":"15206693117309630000","member_id":"15167082162510250000","goods_id":"15158120087923360000","goods_num":"5","goods_name":"创维55G7(55英寸)HDR4K超高清25核WIFI智能","goods_image":"http://img.lion-mall.com/goods/20180113/930e8be3bca4dce663427881c4a0bb64.jpg","spec_desc":"","spec1_name":"尺寸","spec1_value":"55英寸(积分价)","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":834,"is_have_point":"1","model_id":"15158120087913590000"}]}]
     */

    private boolean status;
    private String msg;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    //商店名称
    public static class DataBean implements Serializable {
        /**
         * store_name : 泊爱电脑手机
         * user_id : 2997
         * store_id : 15036517189924090000
         * list : [{"goods_price":2798,"cart_id":"15206697631223840000","member_id":"15167082162510250000","goods_id":"15157284674419540000","goods_num":"1","goods_name":"vivo X9s Plus 全网通 4GB+64GB","goods_image":"http://img.lion-mall.com/goods/20180112/f1ce79c40e7a16caef3d551e87cbd54f.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"黑 4+64全网通","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15157284674402800000"},{"goods_price":1499,"cart_id":"15206697301518310000","member_id":"15167082162510250000","goods_id":"15153949350638380000","goods_num":"5","goods_name":"华为手机NOVA 青春全网4-64G","goods_image":"http://img.lion-mall.com/goods/20180108/96ca747aeaffacc6b75be3f1b72827f0.png","spec_desc":"","spec1_name":"颜色","spec1_value":"蓝色","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15153949350627100000"},{"goods_price":11288,"cart_id":"15206693537135720000","member_id":"15167082162510250000","goods_id":"15157396518144480000","goods_num":"5","goods_name":" Apple MacBook Pro 13.3英寸笔记本电脑","goods_image":"http://img.lion-mall.com/goods/20180112/3c058df9cdb3c1e7ce786bbdc0186b39.jpg","spec_desc":"","spec1_name":"颜色","spec1_value":"银 新MACBOOK PRO-13寸I5-2.3/8-256GB","spec2_name":"","spec2_value":"","proportion_return":"50","goods_points":0,"is_have_point":"1","model_id":"15157396518138430000"}]
         */

        private String store_name;
        private String user_id;
        private String store_id;
        private List<ListBean> list;
        private boolean data_tag;
        private  boolean isSelect;

        public boolean isData_tag() {
            return data_tag;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public void setData_tag(boolean data_tag) {
            this.data_tag = data_tag;
        }

        public boolean getData_tag() {
            return data_tag;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        //商品项
        public static class ListBean implements Serializable{
            /**
             * goods_price : 2798
             * cart_id : 15206697631223840000
             * member_id : 15167082162510250000
             * goods_id : 15157284674419540000
             * goods_num : 1
             * goods_name : vivo X9s Plus 全网通 4GB+64GB
             * goods_image : http://img.lion-mall.com/goods/20180112/f1ce79c40e7a16caef3d551e87cbd54f.jpg
             * spec_desc :
             * spec1_name : 颜色
             * spec1_value : 黑 4+64全网通
             * spec2_name :
             * spec2_value :
             * proportion_return : 50
             * goods_points : 0
             * is_have_point : 1
             * model_id : 15157284674402800000
             */

            private double goods_price;
            private String cart_id;
            private String member_id;
            private String goods_id;
            private int goods_num;
            private String goods_name;
            private String goods_image;
            private String spec_desc;
            private String spec1_name;
            private String spec1_value;
            private String spec2_name;
            private String spec2_value;
            private String proportion_return;
            private String goods_points;
            private String is_have_point;
            private String model_id;
            private boolean isSelect;
            private  String user_id;

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_id() {
                return user_id;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            private boolean goods_tag;

            public void setGoods_tag(boolean goods_tag) {
                this.goods_tag = goods_tag;
            }

            public boolean getGoods_tag() {
                return goods_tag;
            }

            public double getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(double goods_price) {
                this.goods_price = goods_price;
            }

            public String getCart_id() {
                return cart_id;
            }

            public void setCart_id(String cart_id) {
                this.cart_id = cart_id;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getSpec_desc() {
                return spec_desc;
            }

            public void setSpec_desc(String spec_desc) {
                this.spec_desc = spec_desc;
            }

            public String getSpec1_name() {
                return spec1_name;
            }

            public void setSpec1_name(String spec1_name) {
                this.spec1_name = spec1_name;
            }

            public String getSpec1_value() {
                return spec1_value;
            }

            public void setSpec1_value(String spec1_value) {
                this.spec1_value = spec1_value;
            }

            public String getSpec2_name() {
                return spec2_name;
            }

            public void setSpec2_name(String spec2_name) {
                this.spec2_name = spec2_name;
            }

            public String getSpec2_value() {
                return spec2_value;
            }

            public void setSpec2_value(String spec2_value) {
                this.spec2_value = spec2_value;
            }

            public String getProportion_return() {
                return proportion_return;
            }

            public void setProportion_return(String proportion_return) {
                this.proportion_return = proportion_return;
            }

            public String getGoods_points() {
                return goods_points;
            }

            public void setGoods_points(String goods_points) {
                this.goods_points = goods_points;
            }

            public String getIs_have_point() {
                return is_have_point;
            }

            public void setIs_have_point(String is_have_point) {
                this.is_have_point = is_have_point;
            }

            public String getModel_id() {
                return model_id;
            }

            public void setModel_id(String model_id) {
                this.model_id = model_id;
            }
        }
    }
}
