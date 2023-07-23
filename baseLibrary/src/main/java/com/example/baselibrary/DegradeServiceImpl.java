package com.example.baselibrary;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 实现DegradeService进行全局处理，功能类似于拦截器
 * 1. 如果同时有单个的 NavigationCallback，优先级比全局处理的高，不会再进入DegradeService。
 * 2. 实现DegradeService，Route注解采用任意的Path都可以。
 * 3. onLost()会在跳转失败后回调。
 */
@Route(path = "/degrade/Service")
public class DegradeServiceImpl implements DegradeService {

    @Override
    public void onLost(Context context, Postcard postcard) {
        ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_LOAD_ERROR).navigation();
        Log.e("DegradeServiceImpl","找不到目标页面，跳转至备用页面");
    }

    /**
     * 降级处理的初始化，会在sdk初始化的时候调用该方法，仅会调用一次。
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        // 会在sdk初始化的时候调用且仅调用一次
        Log.e("DegradeServiceImpl","降级处理初始化");
    }
}
