package com.example.zhongxianfeng.ganknews.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhongxianfeng.ganknews.R;
import com.example.zhongxianfeng.ganknews.app.utils.CategoryType;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.DaoGankEntity;

import java.util.List;


public class ArticleAdapter extends BaseQuickAdapter<DaoGankEntity,BaseViewHolder> {

    public ArticleAdapter( @Nullable List<DaoGankEntity> data) {
        super(R.layout.item_collection, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DaoGankEntity item) {
        helper.setText(R.id.tvDesc, item.desc);
        ImageView ivImage = helper.getView(R.id.ivImage);
        if (item.type.equals(CategoryType.ANDROID_STR)){
            ivImage.setImageResource(R.mipmap.android);
        }else if (item.type.equals(CategoryType.QIAN_STR)){
            ivImage.setImageResource(R.mipmap.html);
        }else if (item.type.equals(CategoryType.EXPAND_STR)){
            ivImage.setImageResource(R.mipmap.html);
        }
    }
}
