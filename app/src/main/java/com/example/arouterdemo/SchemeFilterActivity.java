package com.example.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.BaseActivity;

public class SchemeFilterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 获取到Uri
        Uri uri = getIntent().getData();
        // 2. 进行跳转
        ARouter.getInstance()
                .build(uri)
                .navigation();
        // 3.销毁该Activity
        finish();
    }
}