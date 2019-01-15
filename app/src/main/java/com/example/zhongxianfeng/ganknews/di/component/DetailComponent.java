package com.example.zhongxianfeng.ganknews.di.component;

import com.example.zhongxianfeng.ganknews.di.module.DetailModule;
import com.example.zhongxianfeng.ganknews.mvp.ui.activity.DetailActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = DetailModule.class, dependencies = AppComponent.class)
public interface DetailComponent {
    void inject(DetailActivity activity);
}