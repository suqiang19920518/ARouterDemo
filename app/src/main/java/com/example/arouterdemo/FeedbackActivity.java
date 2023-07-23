package com.example.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

@Route(path = ARouterConstants.ACTIVITY_URL_FEEDBACK, extras = Constants.NETWORK_CONNECT)
public class FeedbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }
}