package com.example.zhongxianfeng.ganknews.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.zhongxianfeng.ganknews.R;
import com.example.zhongxianfeng.ganknews.app.utils.CategoryType;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.GankEntity;
import com.jess.arms.base.BaseHolder;

import butterknife.BindView;


public class CategoryItemHolder extends BaseHolder<GankEntity.ResultsBean> {

    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.tvAuthor)
    TextView tvAuthor;
    @BindView(R.id.tvDate)
    TextView tvDate;


    public CategoryItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GankEntity.ResultsBean data, int position) {
        tvDate.setText(data.publishedAt);
        tvAuthor.setText(data.who);
        tvDesc.setText(data.desc);
        if (data.type.equals(CategoryType.ANDROID_STR)){
            ivImage.setImageResource(R.mipmap.android);
        }else  if (data.type.equals(CategoryType.QIAN_STR)){
            ivImage.setImageResource(R.mipmap.html);
        }else  if (data.type.equals(CategoryType.EXPAND_STR)){
            ivImage.setImageResource(R.mipmap.expand);
        }
    }
}
