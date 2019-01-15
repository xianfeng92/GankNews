package com.example.zhongxianfeng.ganknews.di.component;

import com.example.zhongxianfeng.ganknews.di.module.WelfareModule;
import com.example.zhongxianfeng.ganknews.mvp.ui.fragment.WelfareFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = WelfareModule.class, dependencies = AppComponent.class)
public interface WelfareComponent {
    void inject(WelfareFragment fragment);
}