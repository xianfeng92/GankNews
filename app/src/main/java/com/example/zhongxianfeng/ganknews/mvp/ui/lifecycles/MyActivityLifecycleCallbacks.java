package com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.zhongxianfeng.ganknews.R;
import timber.log.Timber;
/*
* 全局监听整个 App 所有 Activity 的生命周期 (包括三方库), 并可向其生命周期内插入任意代码
* */
public class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Timber.w(activity + " - onActivityCreated");
        //这里全局给Activity设置toolbar和title,你想象力有多丰富,这里就有多强大,以前放到BaseActivity的操作都可以放到这里
        if (activity.findViewById(R.id.toolbar) != null) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).setSupportActionBar((Toolbar) activity.findViewById(R.id.toolbar));
                ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.setActionBar((android.widget.Toolbar) activity.findViewById(R.id.toolbar));
                    activity.getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }
        if (activity.findViewById(R.id.toolbar_title) != null) {
            ((TextView) activity.findViewById(R.id.toolbar_title)).setText(activity.getTitle());
        }
        if (activity.findViewById(R.id.toolbar_back) != null) {
            activity.findViewById(R.id.toolbar_back).setOnClickListener(v -> {
                activity.onBackPressed();
            });
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
