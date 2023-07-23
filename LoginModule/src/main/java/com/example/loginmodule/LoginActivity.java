package com.example.loginmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

@Route(path = ARouterConstants.ACTIVITY_URL_LOGIN)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mContainer = findViewById(R.id.container);
        findViewById(R.id.tv_start_register).setOnClickListener(this);
        findViewById(R.id.tv_start_password).setOnClickListener(this);
        findViewById(R.id.tv_start_phone_number).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_start_register) {
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_REGISTER)
                    .withString("fragmentPath", ARouterConstants.ACTIVITY_URL_EMAIL_REGISTER_FRAGMENT)
                    .navigation();
        } else if (id == R.id.tv_start_password) {
            // 获取到目标Fragment
            Fragment fragment = (Fragment) ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_PASSWORD_LOGIN_FRAGMENT).navigation();
            showFragment(fragment);
        } else if (id == R.id.tv_start_phone_number) {
            // 获取到目标Fragment
            Fragment fragment = (Fragment) ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_PHONE_NUMBER_LOGIN_FRAGMENT).navigation();
            showFragment(fragment);
        }
    }

    @Override
    public void onBackPressed() {
        if (mContainer.getVisibility() == View.VISIBLE) {
            hiddenFragment();
        } else {
            super.onBackPressed();
        }
    }

    public void showFragment(Fragment fragment) {
        mContainer.setVisibility(View.VISIBLE);
        //在Activity中加载该Frgment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void hiddenFragment() {
        mContainer.setVisibility(View.GONE);
    }
}