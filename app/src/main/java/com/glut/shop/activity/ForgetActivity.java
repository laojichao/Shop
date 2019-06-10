package com.glut.shop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.bean.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 时间 ：  2019/6/7      14:15
 * 创建人：  Ahel
 * 包名：   com.glut.shop.activity
 * 类名：   ForgetActivity
 * 功能：    TODO
 * 主要方法：
 */
public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar forget_head;
    private Button btn_forget;
    private EditText forget_name;
    private EditText forget_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forget);

        init();
    }

    private void init() {
        btn_forget = findViewById(R.id.btn_forget);

        forget_head = findViewById(R.id.forget_head);
        forget_head.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        forget_name =findViewById(R.id.forget_name);
        forget_password =findViewById(R.id.forget_password);

        btn_forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_forget:
                equal();
                break;
        }
    }

    private void equal() {
        BmobQuery<User> categoryBmobQuery = new BmobQuery<>();
        String name = forget_name.getText().toString().trim();
        categoryBmobQuery.addWhereEqualTo("username",name);
        categoryBmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    if(list.toString()!="[]"){
                        Toast.makeText(ForgetActivity.this,"查询成功"+list.toString()+"查询成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ForgetActivity.this, "没有这个帐号" + list.toString() , Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("BMOB", e.toString());
                    Toast.makeText(ForgetActivity.this,"查询失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
