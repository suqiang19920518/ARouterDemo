package com.example.baselibrary;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * priority: 优先级，不能有相同的数值，适用于多个拦截器的情况。
 * priority数值越小，越先执行，优先级越高。
 */
@Interceptor(priority = 5, name = "登录拦截器")
public class LoginInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals(ARouterConstants.ACTIVITY_URL_FEEDBACK)) {  // 如果目标是"反馈页面"
            if (true) {   // 如果没有登录，跳转到登陆页面。
                // 终止跳转
                callback.onInterrupt(null);
                //callback.onInterrupt(new RuntimeException()) // 抛出异常

                ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_LOGIN)
                        .withString("fromType", "feedback")
                        .navigation();
            } else {
                // 继续跳转
                callback.onContinue(postcard);
            }
        } else {
            // 继续跳转
            callback.onContinue(postcard);
        }

    }

    /**
     * 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次。
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        // 会在sdk初始化的时候调用且仅调用一次
        Log.e("LoginInterceptor","登录拦截器初始化");
    }
}
