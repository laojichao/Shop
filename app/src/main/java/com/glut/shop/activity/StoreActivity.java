package com.glut.shop.activity;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.glut.shop.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class StoreActivity extends ActivityGroup implements OnClickListener {
    private static final String TAG = "DepartmentStoreActivity";
    @Bind(R.id.ll_container)
    LinearLayout ll_container;
    @Bind(R.id.ll_first)
    LinearLayout ll_first;
    @Bind(R.id.ll_second)
    LinearLayout ll_second;
    @Bind(R.id.ll_third)
    LinearLayout ll_third;
    @Bind(R.id.ll_four)
    LinearLayout ll_four;
    private Bundle mBundle = new Bundle(); // 声明一个包裹对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        // 从布局文件中获取名叫ll_container的线性布局，用于存放内容视图
        ll_first.setOnClickListener(this); // 给第一个标签注册点击监听器
        ll_second.setOnClickListener(this); // 给第二个标签注册点击监听器
        ll_third.setOnClickListener(this); // 给第三个标签注册点击监听器
        ll_four.setOnClickListener(this);
        mBundle.putString("tag", TAG); // 往包裹中存入名叫tag的标记串
        changeContainerView(ll_first); // 默认显示第一个标签的内容视图
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_first || v.getId() == R.id.ll_second || v.getId() == R.id.ll_third || v.getId() == R.id.ll_four) {
            changeContainerView(v); // 点击了哪个标签，就切换到该标签对应的内容视图
        }
    }

    // 内容视图改为展示指定的视图
    private void changeContainerView(View v) {
        ll_first.setSelected(false); // 取消选中第一个标签
        ll_second.setSelected(false); // 取消选中第二个标签
        ll_third.setSelected(false); // 取消选中第三个标签
        ll_four.setSelected(false);
        v.setSelected(true); // 选中指定标签
        if (v == ll_first) {
            // 切换到第一个活动页面DepartmentHomeActivity
            toActivity("first", HomeActivity.class);
        } else if (v == ll_second) {
            // 切换到第二个活动页面DepartmentClassActivity
            toActivity("second", ClassActivity.class);
        } else if (v == ll_third) {
            // 切换到第三个活动页面DepartmentCartActivity
            toActivity("third", CartActivity.class);
        } else if (v == ll_four) {
            toActivity("four", UserActivity.class);
        }
    }

    // 把内容视图切换到对应的Activity活动页面
    private void toActivity(String label, Class<?> cls) {
        // 创建一个意图，并存入指定包裹
        Intent intent = new Intent(this, cls).putExtras(mBundle);
        // 移除内容框架下面的所有下级视图
        ll_container.removeAllViews();
        // 启动意图指向的活动，并获取该活动页面的顶层视图
        View v = getLocalActivityManager().startActivity(label, intent).getDecorView();
        // 设置内容视图的布局参数
        v.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        // 把活动页面的顶层视图（即内容视图）添加到内容框架上
        ll_container.addView(v);
    }

    /**
     * 退出应用
     */
    private long clickTime = 0; //记录第一次点击的时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - clickTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                clickTime = System.currentTimeMillis();
            } else {
                this.finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
