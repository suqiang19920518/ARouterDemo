package com.example.loginmodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.BaseActivity;
import com.example.baselibrary.Constants;

/**
 * Fragment采用绿色通道，不会进行拦截，因此无法使用拦截器拦截Fragment的跳转。
 */
@Route(path = ARouterConstants.ACTIVITY_URL_PASSWORD_LOGIN_FRAGMENT, extras = Constants.NETWORK_CONNECT)
public class PasswordLoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password_login, container, false);
        view.findViewById(R.id.tv_back_to_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_MAIN).navigation();
            }
        });
        return view;
    }
}