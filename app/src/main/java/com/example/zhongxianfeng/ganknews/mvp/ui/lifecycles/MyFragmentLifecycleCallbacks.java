package com.example.zhongxianfeng.ganknews.mvp.ui.lifecycles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.jess.arms.base.App;
import com.squareup.leakcanary.RefWatcher;

/*
* 全局监听整个 App 所有 Fragment 的生命周期 (包括三方库), 并可向其生命周期内插入任意代码
* */
public class MyFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    @Override
    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        // 在配置变化的时候将这个 Fragment 保存下来,在 Activity 由于配置变化重建是重复利用已经创建的Fragment。
        // https://developer.android.com/reference/android/app/Fragment.html?hl=zh-cn#setRetainInstance(boolean)
        // 在 Activity 中绑定少量的 Fragment 建议这样做,如果需要绑定较多的 Fragment 不建议设置此参数,如 ViewPager 需要展示较多 Fragment
        f.setRetainInstance(true);
    }

    @Override
    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        ((RefWatcher) ((App) f.getActivity().getApplication()).getAppComponent().extras().get(RefWatcher.class.getName())).watch(f);
    }
}
