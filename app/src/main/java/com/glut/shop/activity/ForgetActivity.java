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
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ForgetActivity";
    private EditText et_changepassword_email;
//    private EditText et_changepassword_newpassword;
    private Button btn_changepassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        initView();
    }

    private void initView() {
        et_changepassword_email = (EditText)findViewById(R.id.et_changepassword_email);
//        et_changepassword_newpassword = (EditText)findViewById(R.id.et_changepassword_newpassword);
        btn_changepassword = (Button)findViewById(R.id.btn_changepassword);
        btn_changepassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_changepassword:
                changePassword();
                break;
        }
    }

/*    private void equal() {
        BmobQuery<User> categoryBmobQuery = new BmobQuery<>();
        String name = et_changepassword_username.getText().toString().trim();
        categoryBmobQuery.addWhereEqualTo("username",name);
        categoryBmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    if(list.toString()!="[]"){
                        Toast.makeText(ForgetActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ForgetActivity.this, "没有这个帐号", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("BMOB", e.toString());
                    Toast.makeText(ForgetActivity.this,"查询失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/

    private void changePassword() {
        String email = et_changepassword_email.getText().toString().trim();
        BmobUser.resetPasswordByEmail(email, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e == null) {
                    Toast.makeText(ForgetActivity.this, "重置密码请求成功，请到" + email + "邮箱进行密码重置操作", Toast.LENGTH_SHORT).show();
//                    finish();
                }else {
                    Log.e("BMOB", e.toString());
                    Toast.makeText(ForgetActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



