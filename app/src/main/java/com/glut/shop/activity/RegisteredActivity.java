package com.glut.shop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_register_username;
    private EditText et_register_age;
    private EditText et_register_desc;
    private EditText et_register_password;
    private EditText et_register_repassword;
    private EditText et_register_email;
    private EditText et_register_phone;
    private Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        intView();
    }

    private void intView() {
        et_register_username = (EditText)findViewById(R.id.et_register_username);
        et_register_age = (EditText)findViewById(R.id.et_register_age);
        et_register_desc = (EditText)findViewById(R.id.et_register_desc);
        et_register_password = (EditText)findViewById(R.id.et_register_password);
        et_register_repassword = (EditText)findViewById(R.id.et_register_repassword);
        et_register_email = (EditText)findViewById(R.id.et_register_email);
        et_register_phone = (EditText)findViewById(R.id.et_register_phone);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                String name = et_register_username.getText().toString().trim();
                String age = et_register_age.getText().toString().trim();
                String desc = et_register_desc.getText().toString().trim();
                String pass = et_register_password.getText().toString().trim();
                String password = et_register_repassword.getText().toString().trim();
                String email = et_register_email.getText().toString().trim();
                //待开启
                String phone = et_register_phone.getText().toString().trim();

                if(!TextUtils.isEmpty(name)&!TextUtils.isEmpty(age) &
                        !TextUtils.isEmpty(pass)&
                        !TextUtils.isEmpty(password)&
                        !TextUtils.isEmpty(email)){
                    if(pass.equals(password)){
                        if (TextUtils.isEmpty(desc)){
                            desc = "这个人很懒，什么都没有留下。";
                        }
                        User user = new User();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.setEmail(email);
                        user.setAge(Integer.parseInt(age));
                        user.setDesc(desc);
                        user.setMobilePhoneNumber(phone);
                        user.signUp(new SaveListener<User>() {

                            @Override
                            public void done(User user, BmobException e) {
                                if(e==null){
                                    Toast.makeText(RegisteredActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    finish();
                                }else {
                                    Toast.makeText(RegisteredActivity.this,"注册失败:"+e.toString(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
