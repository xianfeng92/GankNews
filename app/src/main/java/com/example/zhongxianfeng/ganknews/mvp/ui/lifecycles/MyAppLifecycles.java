package com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.zhongxianfeng.ganknews.BuildConfig;
import com.example.zhongxianfeng.ganknews.app.GreenDaoHelper;
import com.jess.arms.base.App;
import com.jess.arms.base.delegate.AppLifecycles;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import timber.log.Timber;

public class MyAppLifecycles implements AppLifecycles {
    @Override
    public void attachBaseContext(Context base) {
    }

    @Override
    public void onCreate(Application application) {
        if (BuildConfig.LOG_DEBUG) {//Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
        //leakCanary内存泄露检查
        ((App) application).getAppComponent().extras().put(RefWatcher.class.getName(), BuildConfig.USE_CANARY ? LeakCanary.install(application) : RefWatcher.DISABLED);

        //ARouter初始化
        if (BuildConfig.LOG_DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        GreenDaoHelper.initDatabase(application);
    }

    @Override
    public void onTerminate(Application application) {

    }
}
