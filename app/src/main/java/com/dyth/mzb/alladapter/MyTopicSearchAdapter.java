package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dyth.mzb.R;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.beans.topicsearch.TopicSearch;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/29.
 */

public class MyTopicSearchAdapter extends RecyclerView.Adapter {

    private List<TopicSearch.DataBean.TopicListBean> topicListBeans;
    private Context context;
    private List<TopicSearch.DataBean> dataBeans;

    public MyTopicSearchAdapter(List<TopicSearch.DataBean.TopicListBean> topicListBeans, Context context) {
        this.topicListBeans = topicListBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.smallimg, null, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.bigimg, null, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.tv.setText(topicListBeans.get(position).getTitle());
            holder1.tv2.setText(topicListBeans.get(position).getNickname());
            holder1.tv3.setText(topicListBeans.get(position).getPublishTime());
            Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(0)).into(holder1.pic);
        }else{
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.tv.setText(topicListBeans.get(position).getTitle());
            holder2.tv2.setText(topicListBeans.get(position).getNickname());
            holder2.tv3.setText(topicListBeans.get(position).getPublishTime());
            if(topicListBeans.get(position).getImageListThumb().get(0)!=null){
                Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(0)).into(holder2.pic);
            }

        }
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }



     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
