package com.example.registermodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

@Route(path = ARouterConstants.ACTIVITY_URL_REGISTER, extras = Constants.NETWORK_CONNECT)
public class RegisterActivity extends BaseActivity {

    @Autowired
    String fragmentPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 获取到目标Fragment
        Fragment fragment = (Fragment) ARouter.getInstance().build(fragmentPath).navigation();
        showFragment(fragment);
    }

    public void showFragment(Fragment fragment) {
        //在Activity中加载该Frgment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}