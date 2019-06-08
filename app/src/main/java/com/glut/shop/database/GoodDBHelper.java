package com.glut.shop.database;

import android.text.TextUtils;
import android.util.Log;

import com.glut.shop.bean.GoodsInfo;
import com.glut.shop.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * GoodDBHelper
 *
 * @author lao
 * @date 2019/6/7
 * 商品数据库连接
 */
public class GoodDBHelper {
    private static final String TAG = "GoodDBHelper";
    private Connection conn = null; //打开数据库对象
    private PreparedStatement ps = null;//操作整合sql语句的对象
    private ResultSet rs = null;//查询结果的集合

    //GoodDBHelper 对象
    public static GoodDBHelper dbHelper = null;

    /**
     * 构造方法 私有化
     * */
    private GoodDBHelper(){

    }

    /**
     * 获取MySQL数据库单例类对象
     * */
    public static GoodDBHelper getDbService(){
        if(dbHelper == null){
            dbHelper = new GoodDBHelper();
        }
        return dbHelper;
    }

    /**
     * 查询商品数据
     * */
    public List<GoodsInfo> getGoodsData() throws SQLException {
        //结果存放集合
        List<GoodsInfo> list = new ArrayList<GoodsInfo>();
        //MySQL 语句
        String sql="select * from category";
        //获取链接数据库对象
        conn= DBConnection.getConnection();
        try {
            if(conn != null&&(!conn.isClosed())){
                ps = (PreparedStatement) conn.prepareStatement(sql);
                if(ps != null){
                    rs = ps.executeQuery();
                    if(rs != null){
                        while(rs.next()){
                            GoodsInfo info = new GoodsInfo();
                            info.setId(rs.getString("id"));
                            info.setShop(rs.getString("shop"));
                            info.setPrice(rs.getString("price"));
                            info.setTitle(rs.getString("title"));
                            List<String> spec = new ArrayList<>();
                            spec.add(rs.getString("spec1"));
                            spec.add(rs.getString("spec2"));
                            spec.add(rs.getString("spec3"));
                            spec.add(rs.getString("spec4"));
                            spec.add(rs.getString("spec5"));
                            info.setSpec(spec);
                            info.setFeature1(rs.getNString("feature1"));
                            info.setFeature2(rs.getString("feature2"));
                            List<String> image = new ArrayList<>();
                            image.add(rs.getString("img1"));
                            image.add(rs.getString("img2"));
                            image.add(rs.getString("img3"));
                            image.add(rs.getString("img4"));
                            info.setImg(image);
                            list.add(info);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }

    /**
     * 修改数据库中某个对象的状态   改
     * */
    public int updateGoodsData(String shop, String id) throws SQLException {
        int result = -1;
        if(!TextUtils.isEmpty(id) && TextUtils.isEmpty(shop)){
            //获取链接数据库对象
            conn= DBConnection.getConnection();
            //MySQL 语句
            String sql="update category set shop = ? where id = ?";
            try {
                boolean closed=conn.isClosed();
                if(conn!=null&&(!closed)){
                    ps= (PreparedStatement) conn.prepareStatement(sql);
                    ps.setString(1,shop);//第一个参数state 一定要和上面SQL语句字段顺序一致
                    ps.setString(2,id);//第二个参数 phone 一定要和上面SQL语句字段顺序一致
                    result=ps.executeUpdate();//返回1 执行成功
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.closeAll(conn,ps);//关闭相关操作
        return result;
    }

    /**
     * 批量向数据库插入数据   增
     * */

    public int insertGoodsData(List<GoodsInfo> list) throws SQLException {
        int result = -1;
        if((list != null) && (list.size() > 0)){
            //获取链接数据库对象
            conn = DBConnection.getConnection();
            //MySQL 语句
            String sql = "INSERT INTO category (id,shop,price,title,spec1,spec2,spec3,spec4,spec5,feature1,feature2,img1,img2,img3,img4 VALUES (?,?,?,?,,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                boolean closed = conn.isClosed();
                if((conn != null) && (!closed)){
                    for(GoodsInfo GoodsInfo:list){
                        ps = (PreparedStatement) conn.prepareStatement(sql);
                        String id = GoodsInfo.getId();
                        String shop = GoodsInfo.getShop();
                        String price = GoodsInfo.getPrice();
                        String title = GoodsInfo.getTitle();
                        String spec1 = GoodsInfo.getSpec().get(0);
                        String spec2 = GoodsInfo.getSpec().get(1);
                        String spec3 = GoodsInfo.getSpec().get(2);
                        String spec4 = GoodsInfo.getSpec().get(3);
                        String spec5 = GoodsInfo.getSpec().get(4);
                        String feature1 = GoodsInfo.getFeature1();
                        String feature2 = GoodsInfo.getFeature2();
                        String img1 = GoodsInfo.getImg().get(0);
                        String img2 = GoodsInfo.getImg().get(1);
                        String img3 = GoodsInfo.getImg().get(2);
                        String img4 = GoodsInfo.getImg().get(3);

                        ps.setString(1,id);
                        ps.setString(2,shop);
                        ps.setString(3,price);
                        ps.setString(4,title);
                        ps.setString(5,spec1);
                        ps.setString(6,spec2);
                        ps.setString(7,spec3);
                        ps.setString(8,spec4);
                        ps.setString(9,spec5);
                        ps.setString(10,feature1);
                        ps.setString(11,feature2);
                        ps.setString(12,img1);
                        ps.setString(13,img2);
                        ps.setString(14,img3);
                        ps.setString(15,img4);
                        result = ps.executeUpdate();//返回1 执行成功
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.closeAll(conn,ps);//关闭相关操作
        return result;
    }


    /**
     * 删除数据  删
     * */

    public int delGoodsData(String id) throws SQLException {
        int result = -1;
        if((!TextUtils.isEmpty(id))){
            //获取链接数据库对象
            conn = DBConnection.getConnection();
            //MySQL 语句
            String sql = "delete from GoodsInfo where id=?";
            try {
                boolean closed = conn.isClosed();
                if((conn != null)&&(!closed)){
                    ps = (PreparedStatement) conn.prepareStatement(sql);
                    ps.setString(1, id);
                    result=ps.executeUpdate();//返回1 执行成功
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.closeAll(conn,ps);//关闭相关操作
        return result;
    }

    /*
    *
    * 通过id查询商品数据
    * */
    public GoodsInfo getGoodsById(String id) throws SQLException {
        Log.d(TAG, "getGoodsById: 通过id查询商品信息");
        //结果存放集合
        //MySQL 语句
        GoodsInfo goodsInfo = new GoodsInfo();
        String sql="select * from category where id = " + id ;
        //获取链接数据库对象
        conn = DBConnection.getConnection();
        try {
            if(conn != null && (!conn.isClosed())){
                ps = (PreparedStatement) conn.prepareStatement(sql);
                if(ps != null){
                    rs = ps.executeQuery();
                    if(rs != null){
                        while(rs.next()){
                            Log.d(TAG, "getGoodsById: ");
                            GoodsInfo info = new GoodsInfo();
                            info.setId(rs.getString("id"));
                            info.setShop(rs.getString("shop"));
                            info.setPrice(rs.getString("price"));
                            info.setTitle(rs.getString("title"));
                            List<String> spec = new ArrayList<>();
                            spec.add(rs.getString("spec1"));
                            spec.add(rs.getString("spec2"));
                            spec.add(rs.getString("spec3"));
                            spec.add(rs.getString("spec4"));
                            spec.add(rs.getString("spec5"));
                            info.setSpec(spec);
                            info.setFeature1(rs.getNString("feature1"));
                            info.setFeature2(rs.getString("feature2"));
                            List<String> image = new ArrayList<>();
                            image.add(rs.getString("img1"));
                            image.add(rs.getString("img2"));
                            image.add(rs.getString("img3"));
                            image.add(rs.getString("img4"));
                            info.setImg(image);
                            goodsInfo = info;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeAll(conn,ps,rs);//关闭相关操作
        Log.d(TAG, "getGoodsById: 返回商品数据" + goodsInfo.getTitle());
        return goodsInfo;
    }

}
