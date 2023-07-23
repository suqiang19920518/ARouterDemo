package com.example.registermodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibrary.ARouterConstants;
import com.example.baselibrary.Constants;

/**
 * Fragment拦截方案：采用不直接 navigation目标Fragment，Navigation一个Activity，
 *                 并且将Fragment通过参数传入，这样就能被拦截器所拦截，并进行后续的处理。
 */
@Route(path = ARouterConstants.ACTIVITY_URL_PHONE_NUMBER_REGISTER_FRAGMENT, extras = Constants.NETWORK_CONNECT)
public class PhoneNumberRegisterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_number_register, container, false);
    }
}