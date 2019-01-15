package com.example.zhongxianfeng.ganknews.di.component;

import com.example.zhongxianfeng.ganknews.di.module.ArticleModule;
import com.example.zhongxianfeng.ganknews.mvp.ui.fragment.ArticleFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;


import dagger.Component;

@ActivityScope
@Component(modules = ArticleModule.class, dependencies = AppComponent.class)
public interface ArticleComponent {
    void inject(ArticleFragment fragment);
}