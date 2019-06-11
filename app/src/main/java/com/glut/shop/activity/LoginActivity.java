package com.glut.shop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.glut.shop.application.MainApplication;
import com.glut.shop.bean.User;
import com.glut.shop.model.EventModel;
import com.glut.shop.util.FileUtil;
import com.glut.shop.util.SharedUtil;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_login_username;
    private EditText et_login_password;

    private Button btn_login;

    private TextView tv_forgotPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_login_username =findViewById(R.id.et_login_username);
        et_login_password = findViewById(R.id.et_login_password);
        et_login_username.setText(SharedUtil.getIntance(this).readString("user_id", ""));
        et_login_password.setText(SharedUtil.getIntance(this).readString("password", ""));

        btn_login =findViewById(R.id.btn_login);

        tv_forgotPassword = findViewById(R.id.tv_forgotPassword);

        btn_login.setOnClickListener(this);
        tv_forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:{
                String name = et_login_username.getText().toString().trim();
                String password = et_login_password.getText().toString().trim();
                SharedUtil.getIntance(this).writeString("user_id", name);
                SharedUtil.getIntance(this).writeString("password", password);
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
                                    MainApplication.getInstance().setUser_id(user.getUsername());
                                    EventBus.getDefault().post(user);
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

            case R.id.tv_forgotPassword:{
                Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
