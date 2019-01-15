package com.example.zhongxianfeng.ganknews.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhongxianfeng.ganknews.R;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.GankEntity;
import com.example.zhongxianfeng.ganknews.mvp.ui.holder.WelfareHolder;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;

import java.util.List;




public class WelfareAdapter extends BaseQuickAdapter<GankEntity.ResultsBean,WelfareHolder> {


    public WelfareAdapter( @Nullable List<GankEntity.ResultsBean> data) {
        super(R.layout.item_girls, data);
    }

    @Override
    protected void convert(WelfareHolder helper, GankEntity.ResultsBean item) {
        helper.mImageLoader.loadImage(helper.mAppComponent.appManager().getCurrentActivity() == null
                        ? helper.mAppComponent.application() : helper.mAppComponent.appManager().getCurrentActivity(),
                ImageConfigImpl
                        .builder()
                        .url(item.url)
                        .imageView(helper.getView(R.id.ivImage))
                        .build());
    }
}
