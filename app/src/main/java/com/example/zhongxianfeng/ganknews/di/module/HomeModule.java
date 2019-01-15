package com.example.zhongxianfeng.ganknews.di.module;

import com.example.zhongxianfeng.ganknews.mvp.contract.HomeContract;
import com.example.zhongxianfeng.ganknews.mvp.model.HomeModel;
import com.jess.arms.di.scope.ActivityScope;


import dagger.Module;
import dagger.Provides;


@Module
public class HomeModule {
    private HomeContract.View view;

    /**
     * 构建HomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeContract.View provideHomeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HomeContract.Model provideHomeModel(HomeModel model) {
        return model;
    }
}