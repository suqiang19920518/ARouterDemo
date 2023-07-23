package com.example.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

/**
 * 在activity上添加如下注解，其中extras的值可以作为判断的类型，用于拦截器处理
 */
@Route(path = ARouterConstants.ACTIVITY_URL_MODIFY_INFO, extras = Constants.NETWORK_CONNECT)
public class ModifyInfoActivity extends BaseActivity {

    //注意：此处变量不能申明为 private
    @Autowired
    String mUsername;  //变量名必须要和参数名一致

    @Autowired
    int mAge;  //变量名必须要和参数名一致

    private EditText mEtUserName;
    private EditText mEtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);
        initView();
    }

    private void initView() {
        mEtUserName = findViewById(R.id.et_username);
        mEtAge = findViewById(R.id.et_age);
        mEtUserName.setHint("用户名：" + mUsername);
        mEtAge.setHint("年龄：" + mAge);

        findViewById(R.id.tv_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUserName.getText().toString();
                String age = mEtAge.getText().toString();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(age)) {
                    Toast.makeText(ModifyInfoActivity.this, "请先输入用户信息", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("newUserName", userName);
                intent.putExtra("newAge", age);
                setResult(PersonalInfoActivity.REQUEST_MODIFY_INFO, intent);
                finish();
            }
        });
    }
}