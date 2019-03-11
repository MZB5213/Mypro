package com.dyth.mzb.my.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.my.base.usercenter.UserCenter;
import com.dyth.mzb.my.contact.UserCenterContract;
import com.dyth.mzb.my.presenter.UserCenterPresenterImpl;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class MyFragment extends BaseFragment implements UserCenterContract.IUserCenterView, View.OnClickListener {

    private UserCenterPresenterImpl userCenterPresenter;
    private View view;
    private ImageView mHeadImage;
    /**
     * Myproject
     */
    private TextView mNameMyname;
    /**
     * 4
     */
    private TextView mScCount;
    /**
     * 4
     */
    private TextView mHistroyCount;
    /**
     * 4
     */
    private TextView mGzCount;
    /**
     * 4
     */
    private TextView mPlCount;
    private UserCenter userCenter;
    private TextView editor;
    private TextView my_collection;
    private TextView my_histroy;
    private TextView my_focus;
    private TextView my_comments;
    private ImageView mMyNavition;
    private ImageView seTting;
    private ImageView my_topic;
    private ImageView feedback;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        userCenterPresenter = new UserCenterPresenterImpl(this);
        userCenterPresenter.getUserCenterData();
    }

    @Override
    protected void initView() {



    }

    @Override
    protected View getonCreateView() {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.my_fragment, null, false);
        feedback = view.findViewById(R.id.feedback);
        mMyNavition = (ImageView) view.findViewById(R.id.my_navition);
        my_collection = view.findViewById(R.id.my_collection);
        my_histroy = view.findViewById(R.id.my_histroy);
        my_focus = view.findViewById(R.id.my_focus);
        my_comments = view.findViewById(R.id.my_comments);
        mHeadImage = (ImageView) view.findViewById(R.id.head_image);
        mNameMyname = (TextView) view.findViewById(R.id.name_myname);
        mScCount = (TextView) view.findViewById(R.id.sc_count);
        mHistroyCount = (TextView) view.findViewById(R.id.histroy_count);
        mGzCount = (TextView) view.findViewById(R.id.gz_count);
        mPlCount = (TextView) view.findViewById(R.id.pl_count);
        editor = view.findViewById(R.id.editor);
        seTting = view.findViewById(R.id.setting);
        my_topic = view.findViewById(R.id.my_topic);
        my_topic.setOnClickListener(this);
        seTting.setOnClickListener(this);
        editor.setOnClickListener(this);
        my_collection.setOnClickListener(this);
        my_histroy.setOnClickListener(this);
        my_focus.setOnClickListener(this);
        my_comments.setOnClickListener(this);
        mMyNavition.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }


    @Override
    public void getData(Object o) {
        userCenter = (UserCenter) o;
        //Log.e("99999999999999999",userCenter.toString());
        Glide.with(this).load(userCenter.getData().getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(mHeadImage);
        mNameMyname.setText(userCenter.getData().getNickname().toString());
        mScCount.setText(userCenter.getData().getFavorites() + "");
        mPlCount.setText(userCenter.getData().getComments() + "");
        mGzCount.setText(userCenter.getData().getFollowing() + "");
        mHistroyCount.setText(userCenter.getData().getHistoryReads() + "");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.editor:
                Intent intent = new Intent(getActivity(), MyEditorActivity.class);
                // intent.putExtra("UserCnter",userCenter);
                startActivity(intent);
                break;
            case R.id.my_collection:
                startActivity(new Intent(getActivity(), CollectionActivity.class));
                break;
            case R.id.my_histroy:

                break;
            case R.id.my_focus:
                startActivity(new Intent(getActivity(), FocusActivity.class));
                break;
            case R.id.my_comments:
                startActivity(new Intent(getActivity(),CommentActivity.class));
                break;
            case R.id.my_navition:
                startActivity(new Intent(getActivity(),NoticeActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(getActivity(),SettingActivity.class));
                break;
            case R.id.my_topic:
                startActivity(new Intent(getActivity(),MyTopicActivity.class));
                break;
            case R.id.feedback:
                startActivity(new Intent(getActivity(),FeedBackActivity.class));
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(getActivity(), R.layout.my_fragment, null);
    }


}
