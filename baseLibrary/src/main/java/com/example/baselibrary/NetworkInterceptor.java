package com.example.baselibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * priority: 优先级，不能有相同的数值，适用于多个拦截器的情况。
 * priority数值越小，越先执行，优先级越高。
 */
@Interceptor(priority = 2, name = "网络拦截器")
public class NetworkInterceptor implements IInterceptor {

    private Context context;
    private ConnectivityManager manager;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        // 根据extra属性判断是否是需要拦截的类型
        if (postcard.getExtra() == Constants.NETWORK_CONNECT) {  // 如果目标页面需要网络连接
            if (!isNetworkEnable()) {  //网络未连接，则拦截跳转
                Toast.makeText(context, "网络未连接", Toast.LENGTH_LONG).show();
                callback.onInterrupt(null);
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
        this.context = context;
        manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 会在sdk初始化的时候调用且仅调用一次
        Log.e("NetworkInterceptor","网络拦截器初始化");
    }

    private boolean isNetworkEnable() {
        NetworkInfo active = manager.getActiveNetworkInfo();
        return active != null && active.getState() == NetworkInfo.State.CONNECTED;
    }
}
