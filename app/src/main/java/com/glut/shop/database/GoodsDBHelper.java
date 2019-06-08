/*
package com.glut.shop.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.glut.shop.bean.GoodsInfo;
import com.glut.shop.util.DBConnection;


*/
/**
 * GoodsDBHelper
 *
 * @author lao
 * @date 2019/6/7
 *//*


@SuppressLint("DefaultLocale")
public class GoodsDBHelper {
    private static final String TAG = "GoodsDBHelper";
    // 根据指定条件删除表记录
    public int delete(String condition) throws SQLException {
        // 执行删除记录动作，该语句返回删除记录的数目
        Connection connection = DBConnection.getConnection();
        return  0;
    }

    // 删除该表的所有记录
    public int deleteAll() {
        // 执行删除记录动作，该语句返回删除记录的数目
        return mDB.delete(TABLE_NAME, "1=1", null);
    }

    // 往该表添加一条记录
    public long insert(GoodsInfo info) {
        ArrayList<GoodsInfo> infoArray = new ArrayList<GoodsInfo>();
        infoArray.add(info);
        return insert(infoArray);
    }

    // 往该表添加多条记录
    public long insert(ArrayList<GoodsInfo> infoArray) {
        long result = -1;
        for (GoodsInfo info : infoArray) {
            // 如果存在相同rowid的记录，则更新记录
            if (info.rowid > 0) {
                String condition = String.format("rowid='%d'", info.rowid);
                update(info, condition);
                result = info.rowid;
                continue;
            }
            // 不存在唯一性重复的记录，则插入新记录
            ContentValues cv = new ContentValues();
            cv.put("name", info.name);
            cv.put("desc", info.desc);
            cv.put("price", info.price);
            cv.put("thumb_path", info.thumb_path);
            cv.put("pic_path", info.pic_path);
            // 执行插入记录动作，该语句返回插入记录的行号
            result = mDB.insert(TABLE_NAME, "", cv);
            // 添加成功后返回行号，失败后返回-1
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    // 根据条件更新指定的表记录
    public int update(GoodsInfo info, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("name", info.name);
        cv.put("desc", info.desc);
        cv.put("price", info.price);
        cv.put("thumb_path", info.thumb_path);
        cv.put("pic_path", info.pic_path);
        // 执行更新记录动作，该语句返回记录更新的数目
        return mDB.update(TABLE_NAME, cv, condition, null);
    }

    public int update(GoodsInfo info) {
        // 执行更新记录动作，该语句返回记录更新的数目
        return update(info, "rowid=" + info.rowid);
    }

    // 根据指定条件查询记录，并返回结果数据队列
    public ArrayList<GoodsInfo> query(String condition) {
        String sql = String.format("select rowid,_id,name,desc,price,thumb_path,pic_path" +
                " from %s where %s;", TABLE_NAME, condition);
        Log.d(TAG, "query sql: " + sql);
        ArrayList<GoodsInfo> infoArray = new ArrayList<GoodsInfo>();
        // 执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = mDB.rawQuery(sql, null);
        // 循环取出游标指向的每条记录
        while (cursor.moveToNext()) {
            GoodsInfo info = new GoodsInfo();
            info.rowid = cursor.getLong(0);
            info.xuhao = cursor.getInt(1);
            info.name = cursor.getString(2);
            info.desc = cursor.getString(3);
            info.price = cursor.getFloat(4);
            info.thumb_path = cursor.getString(5);
            info.pic_path = cursor.getString(6);
            infoArray.add(info);
        }
        cursor.close(); // 查询完毕，关闭游标
        return infoArray;
    }

    // 根据行号查询指定记录
    public GoodsInfo queryById(long rowid) {
        GoodsInfo info = null;
        ArrayList<GoodsInfo> infoArray = query(String.format("rowid='%d'", rowid));
        if (infoArray.size() > 0) {
            info = infoArray.get(0);
        }
        return info;
    }

}
*/
