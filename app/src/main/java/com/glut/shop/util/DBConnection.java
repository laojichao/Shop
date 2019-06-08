package com.glut.shop.util;

/**
 * DBConnection
 * 网络数据库连接
 * @author lao
 * @date 2019/6/7
 */
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static String TAG = "DBConnect";
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://120.24.61.225:3306/shop?useSSL=FALSE";
    //mysql5.5以上
//    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DBURL = "jdbc:mysql://120.24.61.225:3306/shop?useSSL=true&serverTimezone=GMT";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "laojichao";

    //获取连接
    public static Connection getConnection() throws SQLException{
        Connection conn = null;
        try {
            Class.forName(DBDRIVER);//获取MYSQL驱动
            conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);//获取连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getConnection: 数据库连接成功");
        return conn;
    }

    /**
     * 关闭数据库
     * */

    public static void closeAll(Connection conn, PreparedStatement ps){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "closeAll: 关闭数据库");
    }

    /**
     * 关闭数据库
     * */

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "closeAll: 关闭数据库");
    }

}
