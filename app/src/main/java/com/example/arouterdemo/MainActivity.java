package com.example.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;

@Route(path = ARouterConstants.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_start_setting).setOnClickListener(this);
        findViewById(R.id.tv_start_personal_info).setOnClickListener(this);
        findViewById(R.id.tv_start_feedback).setOnClickListener(this);
        findViewById(R.id.tv_start_login).setOnClickListener(this);
        findViewById(R.id.tv_start_register).setOnClickListener(this);
        findViewById(R.id.tv_test_degrade).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_start_setting) {
            //应用内简单的跳转
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_SETTING).navigation();
        } else if (id == R.id.tv_test_degrade) {
            //测试跳转出错，找不到目标页面，降级处理
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_TEST).navigation();
        } else if (id == R.id.tv_start_personal_info) {
            UserInfo userInfo = new UserInfo(1, "湖北宜昌", "13768909765", "3425678834213498033");
            //应用内简单的跳转，携带参数
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_PERSONAL_INFO)
                    .withString("userName", "张三")
                    .withInt("age", 23)
                    .withSerializable("userInfo", userInfo)
                    .navigation();
        } else if (id == R.id.tv_start_login) {
            //模块之间跳转，支持跳转动画
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityOptionsCompat customAnimation = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left);
                ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_LOGIN)
                        .withOptionsCompat(customAnimation)
                        .navigation();
            } else {
                ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_LOGIN)
                        .withTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        .navigation();
                Log.e(TAG,  "API < 16,不支持新版本动画");
            }

        } else if (id == R.id.tv_start_register) {
            //模块之间跳转，通过Uri进行跳转
            // 1. 默认路径
            Uri uri = Uri.parse(ARouterConstants.ACTIVITY_URL_REGISTER);
            // 2. 完整路径
            // Uri uri = Uri.parse("register://www.register.com:1226" + ARouterConstants.ACTIVITY_URL_REGISTER);
            ARouter.getInstance().build(uri)
                    .withString("fragmentPath", ARouterConstants.ACTIVITY_URL_PHONE_NUMBER_REGISTER_FRAGMENT)
                    .navigation();
//            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_REGISTER)
//                    .withString("fragmentPath", ARouterConstants.ACTIVITY_URL_PHONE_NUMBER_REGISTER_FRAGMENT)
//                    .navigation();
        } else if (id == R.id.tv_start_feedback) {
            //监听路由操作, 回调相应方法（包括拦截监听）
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_FEEDBACK).navigation(this, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    //目标路由被发现时调用
                    Log.e(TAG, "onFound: 发现路由" + postcard.getPath());
                }

                @Override
                public void onLost(Postcard postcard) {
                    //路由丢失后调用
                    Log.e(TAG, "onLost: 路由丢失");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    //路由到达时调用
                    Log.e(TAG, "onArrival: 路由到达" + postcard.getPath());
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    //路由被拦截后调用
                    Log.e(TAG, "onInterrupt: 路由被拦截" + postcard.getPath());
                }
            });
        }
    }
}