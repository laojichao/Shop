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

/**
 * 时间 ：  2019/6/6      16:30
 * 创建人：  Ahel
 * 包名：   com.glut.shop.activity
 * 类名：   RegisteredActivity
 * 功能：    TODO
 * 主要方法：
 */
public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar registered_head;
    private Button res_registered;
    private EditText res_name;
    private EditText res_age;
    private EditText res_desc;
    private EditText res_pass;
    private EditText res_password;
    private EditText res_email;
    private EditText res_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registered);
        registered_head = findViewById(R.id.registered_head);
        setSupportActionBar(registered_head);
        registered_head.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        intView();
    }

    private void intView() {
        res_registered =findViewById(R.id.res_Registered);
        res_name = findViewById(R.id.res_name);
        res_age = findViewById(R.id.res_age);
        res_desc =findViewById(R.id.res_desc);
        res_pass = findViewById(R.id.res_pass);
        res_password = findViewById(R.id.res_password);
        res_email = findViewById(R.id.res_email);
        res_phone =findViewById(R.id.res_phone);

        res_registered.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.res_Registered:
                String name = res_name.getText().toString().trim();
                String age = res_age.getText().toString().trim();
                String desc = res_desc.getText().toString().trim();
                String pass = res_pass.getText().toString().trim();
                String password = res_password.getText().toString().trim();
                String email = res_email.getText().toString().trim();
                //待开启
                String phone = res_phone.getText().toString().trim();

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
