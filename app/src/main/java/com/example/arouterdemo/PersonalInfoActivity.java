package com.example.arouterdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

@Route(path = ARouterConstants.ACTIVITY_URL_PERSONAL_INFO, extras = Constants.NETWORK_CONNECT)
public class PersonalInfoActivity extends BaseActivity {

    public static final int REQUEST_MODIFY_INFO = 1000;

    //注意：此处变量不能申明为 private
    @Autowired(name = "userName")
    String mUsername;  //变变量名和参数名不一致

    @Autowired(name = "age")
    int mAge;  //变量名和参数名不一致

    @Autowired(name = "userInfo")
    UserInfo mUserInfo;  //变量名和参数名不一致

    private TextView mTvUserName;
    private TextView mTvAge;
    private TextView mTvSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        initView();
    }

    private void initView() {
        mTvUserName = findViewById(R.id.tv_user_name);
        mTvAge = findViewById(R.id.tv_user_age);
        mTvSex = findViewById(R.id.tv_sex);
        mTvUserName.setText("用户名：" + mUsername);
        mTvAge.setText("年龄：" + mAge);
        mTvSex.setText("性别：" + mUserInfo.getSex());

        findViewById(R.id.tv_modify_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //应用内简单的跳转，携带参数，startActivityForResult实现
                ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_MODIFY_INFO)
                        .withString("mUsername", mUsername)
                        .withInt("mAge", mAge)
                        .navigation(PersonalInfoActivity.this, REQUEST_MODIFY_INFO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_MODIFY_INFO) {
            if (data != null) {
                mUsername = data.getStringExtra("newUserName");
                mAge = Integer.parseInt(data.getStringExtra("newAge"));
                mTvUserName.setText("用户名：" + mUsername);
                mTvAge.setText("年龄：" + mAge);
            }
        }
    }
}