package com.glut.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.bean.User;
import com.glut.shop.model.EventModel;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 时间 ：  2019/6/6      16:22
 * 创建人：  Ahel
 * 包名：   com.glut.shop.activity
 * 类名：   LoginActivity
 * 功能：    TODO
 * 主要方法：
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar login_head;

    private EditText login_name;
    private EditText login_password;

    private Button btn_login;
    private Button btn_registered;

    private TextView forget_password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        login_head = findViewById(R.id.login_head);
        login_head.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        login_name =findViewById(R.id.login_name);
        login_password = findViewById(R.id.login_password);

        btn_login =findViewById(R.id.btn_login);
        btn_registered = findViewById(R.id.btn_registered);

        forget_password = findViewById(R.id.forget_password);

        btn_login.setOnClickListener(this);
        btn_registered.setOnClickListener(this);
        forget_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:{
                String name = login_name.getText().toString().trim();
                String password = login_password.getText().toString().trim();
                if(!TextUtils.isEmpty(name)&!TextUtils.isEmpty(password)){
                    final User user = new User();
                    user.setUsername(name);
                    user.setPassword(password);
                    user.login(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if( e == null ){
                                if(user.getEmailVerified()){
                                    EventBus.getDefault().post(new EventModel(EventModel.CODE_LOGIN));
                                    finish();
                                }else {
                                    Toast.makeText(LoginActivity.this,"请前往邮箱验证",Toast.LENGTH_SHORT).show();
                                }
                            } else{
                                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.btn_registered:{
                Intent intent = new Intent(LoginActivity.this,RegisteredActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.forget_password:{
                Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
