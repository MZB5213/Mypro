package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.my.base.aboutus.AboutUs;
import com.dyth.mzb.my.contact.AboutUSContract;
import com.dyth.mzb.my.presenter.AboutUsPresenterImpl;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class AboutUsFragment extends BaseActivity implements AboutUSContract.IAboutUsView {

    private WebView web;
    private AboutUs aboutUs;
    private WebView mWeb;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        AboutUsPresenterImpl aboutUsPresenter = new AboutUsPresenterImpl(this);
        aboutUsPresenter.getAboutUs();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.about_fragment;
    }

    //WebView
    class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数
            //        addImageClickListner();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        web.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }


    @Override
    protected void initView() {
        mWeb = (WebView) findViewById(R.id.web);

    }



    @Override
    public void getAboutData(Object T) {
        aboutUs = (AboutUs) T;
        mWeb.loadDataWithBaseURL(null, aboutUs.getData().getAboutUs(), "text/html", "UTF-8", null);
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        mWeb.setWebViewClient(new WebViewClient());

    }


}
