package com.example.zhongxianfeng.ganknews.app;


import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.example.zhongxianfeng.ganknews.mvp.model.api.Api;
import com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles.MyActivityLifecycleCallbacks;
import com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles.MyAppLifecycles;
import com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles.MyFragmentLifecycleCallbacks;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;


import java.util.List;


/**
 * app的全局配置信息在此配置,需要将此实现类声明到AndroidManifest中
 * Created by jess on 12/04/2017 17:25
 * Contact with jess.yan.effort@gmail.com
 */

public class GlobalConfiguration implements ConfigModule {


    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //使用builder可以为框架配置一些配置信息
        builder.baseurl(Api.APP_DOMAIN);
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        //AppDelegate.Lifecycle 的所有方法都会在基类Application对应的生命周期中被调用,所以在对应的方法中可以扩展一些自己需要的逻辑
        lifecycles.add(new MyAppLifecycles());
    }


    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //向Activity的生命周期中注入一些自定义逻辑
        lifecycles.add(new MyActivityLifecycleCallbacks());
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        //向Fragment的生命周期中注入一些自定义逻辑
        lifecycles.add(new MyFragmentLifecycleCallbacks());
    }
}
