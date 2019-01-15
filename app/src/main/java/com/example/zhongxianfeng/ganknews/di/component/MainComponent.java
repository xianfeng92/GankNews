package com.example.zhongxianfeng.ganknews.di.component;

import com.example.zhongxianfeng.ganknews.di.module.MainModule;
import com.example.zhongxianfeng.ganknews.mvp.ui.activity.MainActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;


import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}