package com.example.zhongxianfeng.ganknews.mvp.model;

import android.app.Application;

import com.example.zhongxianfeng.ganknews.app.GreenDaoHelper;
import com.example.zhongxianfeng.ganknews.app.greendao.DaoGankEntityDao;
import com.example.zhongxianfeng.ganknews.mvp.contract.DetailContract;
import com.example.zhongxianfeng.ganknews.mvp.model.api.service.CommonService;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.DaoGankEntity;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.GankEntity;
import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class DetailModel extends BaseModel implements DetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public DetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<GankEntity> getRandomGirl() {
        Observable<GankEntity> randomGirl = mRepositoryManager.obtainRetrofitService(CommonService.class)
                .getRandomGirl();
        return randomGirl;
    }

    @Override
    public List<DaoGankEntity> queryById(String id) {
        return GreenDaoHelper.getDaoSession().getDaoGankEntityDao()
                .queryBuilder()
                .where(DaoGankEntityDao.Properties._id.eq(id))
                .list();
    }

    @Override
    public void removeByid(String id) {
        GreenDaoHelper.getDaoSession().getDaoGankEntityDao()
                .queryBuilder()
                .where(DaoGankEntityDao.Properties._id.eq(id))
                .buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override
    public void addGankEntity(DaoGankEntity entity) {
        GreenDaoHelper.getDaoSession().getDaoGankEntityDao().insert(entity);
    }


}