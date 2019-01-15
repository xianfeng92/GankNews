package com.example.zhongxianfeng.ganknews.mvp.ui.adapter;

import android.view.View;

import com.example.zhongxianfeng.ganknews.R;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.GankEntity;
import com.example.zhongxianfeng.ganknews.mvp.ui.holder.CategoryItemHolder;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;



public class CategoryAdapter extends DefaultAdapter<GankEntity.ResultsBean> {

    public CategoryAdapter(List<GankEntity.ResultsBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<GankEntity.ResultsBean> getHolder(View v, int viewType) {
        return new CategoryItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_android;
    }

}
