package com.glut.shop.bean;

import java.util.List;

/**
 * BannerBean
 *
 * @author lao
 * @date 2019/6/3
 */
public class BannerBean {

    /**
     * status : 0
     * msg : success
     * data : [{"img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530962561545&di=f6af0eb6d96e5540baf2ce3bc96dca38&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0118a6576505160000018c1bc1c1d9.jpg%401280w_1l_2o_100sh.jpg"},{"img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530962666446&di=d7d90171e1fd6cc69352b73e2f8df529&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F017338576505290000012e7e45db9f.jpg%401280w_1l_2o_100sh.jpg"},{"img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531557498&di=5e4a5342ae724f219b004ccad7b6fa82&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F017e0458212939a84a0e282bca0f71.jpg%401280w_1l_2o_100sh.jpg"},{"img":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1559530726&di=0bcc4a90595ced247cf852cd02dd8fc6&src=http://pic26.nipic.com/20121227/6431160_193247464000_2.jpg"}]
     */

    private String status;
    private String msg;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public static class DataBean {
        /**
         * img : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530962561545&di=f6af0eb6d96e5540baf2ce3bc96dca38&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0118a6576505160000018c1bc1c1d9.jpg%401280w_1l_2o_100sh.jpg
         */

        private String img;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
