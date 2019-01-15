package com.example.zhongxianfeng.ganknews.di.component;

import com.example.zhongxianfeng.ganknews.di.module.MeiziModule;
import com.example.zhongxianfeng.ganknews.mvp.ui.fragment.MeiziFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;


import dagger.Component;

@ActivityScope
@Component(modules = MeiziModule.class, dependencies = AppComponent.class)
public interface MeiziComponent {
    void inject(MeiziFragment fragment);
}