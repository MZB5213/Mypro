package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.CollectionAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.beans.Collection.Collection;
import com.dyth.mzb.infomation.beans.comments.CommentsList;
import com.dyth.mzb.infomation.beans.comments.CommentsResponse;
import com.dyth.mzb.infomation.beans.details.Details;
import com.dyth.mzb.infomation.beans.givelike.GiveLike;
import com.dyth.mzb.infomation.beans.usercollection.UserCollection;
import com.dyth.mzb.infomation.contract.CollectionContract;
import com.dyth.mzb.infomation.contract.CollectionListContract;
import com.dyth.mzb.infomation.contract.CommentsContract;
import com.dyth.mzb.infomation.contract.CommentsListContract;
import com.dyth.mzb.infomation.contract.GiveLikeContract;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.presenter.CollectionListPresenterImpl;
import com.dyth.mzb.infomation.presenter.CollectionPresenterImpl;
import com.dyth.mzb.infomation.presenter.CommentsListPresenterImpl;
import com.dyth.mzb.infomation.presenter.CommentsPresenterImpl;
import com.dyth.mzb.infomation.presenter.GivePresenterImpl;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class DetailsActivity extends BaseActivity implements InfomationContract.INewsView, CollectionContract.IUserView, CollectionListContract.INewsView, GiveLikeContract.GiveLikeView, CommentsContract.ICommentsView,View.OnClickListener, CommentsListContract.ICommentsListView {

    private TextView title;
    private TextView time;
    private ImageView sc;
    private WebView web;
    private Toolbar mtoolbar;
    private InfoPresenterImpl infoPresenter;
    private String newsId;
    private Details details;
    private RadioGroup navigatin;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    int i = 1;
    private Button wsc;
    private CollectionPresenterImpl collectionPresenter;
    private CollectionListPresenterImpl collectionListPresenter;
    private TextView number;
    private TextView number2;
    private GivePresenterImpl givePresenter;
    private RecyclerView webrlv;
    private List<CommentsList.DataBean.CommentListBean> commentListBeans = new ArrayList<>();
    private CollectionAdapter collectionAdapter;
    private RadioButton rb4;
    boolean flag = true;
    private TextView msize;
    private TextView mfales;
    private EditText edit;
    private TextView mrelease;
    private CommentsPresenterImpl commentsPresenter;
    private String content;
    private PopupWindow popupWindow;
    private CommentsListPresenterImpl commentsListPresenter;




    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsId");
        mtoolbar = findViewById(R.id.mtoolbar);
        title = findViewById(R.id.title);
        time = findViewById(R.id.time);
        sc = findViewById(R.id.sc);
        web = findViewById(R.id.web);
        navigatin = findViewById(R.id.gp);
        rb1 = findViewById(R.id.rbfx);
        rb2 = findViewById(R.id.rbpl);
        rb3 = findViewById(R.id.rbsc);
        rb4 = findViewById(R.id.rbsc2);
        wsc = findViewById(R.id.wsc);
        number = findViewById(R.id.number);
        number2 = findViewById(R.id.number2);
        webrlv = findViewById(R.id.webrlv);
        mtoolbar.setTitle("");
        setSupportActionBar(mtoolbar);
        //创建适配器
        webrlv.setLayoutManager(new LinearLayoutManager(this));
        webrlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        collectionAdapter = new CollectionAdapter(commentListBeans, this);
        webrlv.setAdapter(collectionAdapter);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        number.setOnClickListener(this);
        number2.setOnClickListener(this);
        sc.setOnClickListener(this);
        wsc.setOnClickListener(this);



        //创建Pupupwindow弹窗
        View inflate = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.comments, null, false);
        edit = inflate.findViewById(R.id.edit);
        msize = inflate.findViewById(R.id.msize);
        mfales = inflate.findViewById(R.id.mfales);
        mrelease = inflate.findViewById(R.id.mrelease);
        popupWindow = new PopupWindow(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //Edtext编辑框得监听
       edit.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }
           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }
           @Override
           public void afterTextChanged( Editable s) {
                msize.setText(s.length()+"/150");
                content = s.toString();
           }
       });

        mrelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentsPresenter.getComentData(newsId,content);
                popupWindow.dismiss();
                collectionAdapter.notifyDataSetChanged();
            }
        });

        mfales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this,content,Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }
        });

    }

    @Override
    protected void getData() {


    }
    //我的收藏

    @Override
    public void getCollectionData(Object o) {
        UserCollection userCollection = (UserCollection) o;
        Toast.makeText(this, userCollection.getMessage(), Toast.LENGTH_LONG).show();
    }

    //收藏列表
    @Override
    public void getDataCollection(Object o) {
        Collection collection = (Collection) o;
        List<Collection.DataBean.FavouritNewsListBean> favouritNewsList = collection.getData().getFavouritNewsList();
        List<String> ids = new ArrayList<>();
        for (int j = 0; j < favouritNewsList.size(); j++) {
            if (favouritNewsList.get(j).getNewsId() != null) {
                String s = (String) favouritNewsList.get(j).getNewsId();
                ids.add(s);
            }

        }
        if (ids.contains(newsId)) {
            sc.setVisibility(View.GONE);
            wsc.setVisibility(View.VISIBLE);
            rb3.setVisibility(View.GONE);
            rb4.setVisibility(View.VISIBLE);

        } else {
            sc.setVisibility(View.VISIBLE);
            wsc.setVisibility(View.GONE);
            rb3.setVisibility(View.VISIBLE);
            rb4.setVisibility(View.GONE);
        }


    }

    @Override
    public void getGiveLikeData(Object o) {
        GiveLike giveLike = (GiveLike) o;
        Toast.makeText(this, giveLike.getMessage(), Toast.LENGTH_LONG).show();


    }

    @Override
    public void getCommentData(Object o) {
        CommentsResponse commentsResponse = (CommentsResponse) o;
        Toast.makeText(this,"pl:"+commentsResponse.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.rbfx:

                break;
            case R.id.rbpl:
                popupWindow.showAsDropDown(mtoolbar, 50, 20);
                String string = edit.getText().toString();
                Toast.makeText(DetailsActivity.this, string + "121211212121212", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbsc:
                rb3.setVisibility(View.GONE);
                rb4.setVisibility(View.VISIBLE);
                DetailsActivity.this.sc.setVisibility(View.GONE);
                DetailsActivity.this.wsc.setVisibility(View.VISIBLE);
                collectionPresenter.getUserCollection(newsId, "1");
                break;
            case R.id.rbsc2:
                rb4.setVisibility(View.GONE);
                rb3.setVisibility(View.VISIBLE);
                DetailsActivity.this.wsc.setVisibility(View.GONE);
                DetailsActivity.this.sc.setVisibility(View.VISIBLE);
                collectionPresenter.getUserCollection(newsId, "0");
                break;
            case R.id.number:
                number.setVisibility(View.GONE);
                number2.setVisibility(View.VISIBLE);
                number2.setText("      1");
                givePresenter.getGiveLike(newsId, "0");
                break;
            case R.id.number2:
                number2.setVisibility(View.GONE);
                number.setVisibility(View.VISIBLE);
                number.setText("      0");
                givePresenter.getGiveLike(newsId, "1");
                break;
            case R.id.sc:
                DetailsActivity.this.sc.setVisibility(View.GONE);
                DetailsActivity.this.wsc.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.GONE);
                rb4.setVisibility(View.VISIBLE);
                collectionPresenter.getUserCollection(newsId, "0");
                break;
            case R.id.wsc:
                Log.e("aaaa", "3333333333");
                DetailsActivity.this.wsc.setVisibility(View.GONE);
                DetailsActivity.this.sc.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.GONE);
                rb3.setVisibility(View.VISIBLE);
                collectionPresenter.getUserCollection(newsId, "1");
                break;

        }
    }

    @Override
    public void getCommentsListData(Object o) {
        CommentsList commentsList = (CommentsList) o;
        List<CommentsList.DataBean.CommentListBean> commentList = commentsList.getData().getCommentList();
        this.commentListBeans.addAll(commentList);
        collectionAdapter.notifyDataSetChanged();


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

    //创建P层对象
    @Override
    protected void getpresenter() {
        infoPresenter = new InfoPresenterImpl(this);
        infoPresenter.getDetails(newsId);
        collectionPresenter = new CollectionPresenterImpl(this);
        collectionListPresenter = new CollectionListPresenterImpl(this);
        collectionListPresenter.getCollection();
        givePresenter = new GivePresenterImpl(this);
        commentsPresenter = new CommentsPresenterImpl(this);
        commentsListPresenter = new CommentsListPresenterImpl(this);
        commentsListPresenter.getCommentsListData(newsId);
    }
    //新闻详情
    @Override
    public void getData(Object o) {
        details = (Details) o;
        title.setText(details.getData().getTitle());
        time.setText(details.getData().getPublishTime());
        int isLiked = details.getData().getIsLiked();
        web.loadDataWithBaseURL(null, details.getData().getContent(), "text/html", "UTF-8", null);
        web.getSettings().setJavaScriptEnabled(true); //设置支持Javascript
        web.setWebViewClient(new MyWebViewClient());

        if (isLiked == 0) {
            // Toast.makeText(this,isLiked+"",Toast.LENGTH_LONG).show();
            number2.setVisibility(View.GONE);
            number.setVisibility(View.VISIBLE);
            number.setText("      0");
        } else {
            number2.setVisibility(View.VISIBLE);
            number.setVisibility(View.GONE);
            number2.setText("      1");
        }

    }

}
