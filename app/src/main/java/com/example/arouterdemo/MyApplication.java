package com.example.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    public void initARouter() {
        if (BuildConfig.DEBUG) {  //这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();      //开启打印日志
            ARouter.openDebug();    //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }

        ARouter.init(this);  // 尽可能早，推荐在Application中初始化
    }

}
