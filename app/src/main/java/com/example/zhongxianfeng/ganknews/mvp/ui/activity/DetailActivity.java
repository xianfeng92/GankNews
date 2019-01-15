package com.example.zhongxianfeng.ganknews.mvp.ui.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.zhongxianfeng.ganknews.R;
import com.example.zhongxianfeng.ganknews.di.component.DaggerDetailComponent;
import com.example.zhongxianfeng.ganknews.di.module.DetailModule;
import com.example.zhongxianfeng.ganknews.mvp.contract.DetailContract;
import com.example.zhongxianfeng.ganknews.mvp.model.entity.GankEntity;
import com.example.zhongxianfeng.ganknews.mvp.presenter.DetailPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;


import butterknife.BindView;
import static com.example.zhongxianfeng.ganknews.app.ARouterPaths.MAIN_DETAIL;
import static com.example.zhongxianfeng.ganknews.app.EventBusTags.EXTRA_DETAIL;
import static com.jess.arms.utils.Preconditions.checkNotNull;


@Route(path = MAIN_DETAIL)
public class DetailActivity extends BaseActivity<DetailPresenter> implements DetailContract.View {


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private GankEntity.ResultsBean entity;
    private boolean isFavorite;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        // 获取ARouter传递过来的EXTRA_DETAIL数据
        entity = (GankEntity.ResultsBean) getIntent()
                .getExtras()
                .getSerializable(EXTRA_DETAIL);
        // 从gank随机获取一张picture
        mPresenter.getGirl();
        mPresenter.getQuery(entity._id);
        if (toolbar != null) {
            if (this instanceof AppCompatActivity) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    this.setActionBar((android.widget.Toolbar) this.findViewById(R.id.toolbar));
                    this.getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }

        // TODO: 添加到收藏夹
        fab.setOnClickListener(v -> {
            if (isFavorite) {
                ArmsUtils.makeText(this,"已移除收藏夹");
                mPresenter.removeByid(entity);
            } else {
                ArmsUtils.makeText(this,"已添加到收藏夹");
                mPresenter.addToFavorites(entity);
            }
        });

        initWebView();

    }

    @Override
    public void onFavoriteChange(boolean isFavorite) {
        this.isFavorite = isFavorite;
        if (isFavorite){
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        }else {
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.C4)));
        }

    }
    private void initWebView() {
        WebSettings settings = webview.getSettings();
        // 将图片调整到适合webview的大小
        settings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);
        // 支持缩放，默认为true
        settings.setSupportZoom(true);
        // 设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setBuiltInZoomControls(true);
        // 隐藏原生的缩放控件
        settings.setDisplayZoomControls(false);
        // 打开网页时不调用系统浏览器，而是在本WebView中显示；在网页上的所有加载都经过这个方法,这个函数我们可以做很多操作
        webview.setWebViewClient(new WebViewClient(){

            //拦截url
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        // 加载一个url
        webview.loadUrl(entity.url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setData(String url) {
        ArmsUtils.obtainAppComponentFromContext(this).imageLoader().loadImage(this,
                ImageConfigImpl
                        .builder()
                        .url(url)
                        .imageView(imageView)
                        .build());
    }
}
