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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/29.
 */

public class MySearchAdapter extends RecyclerView.Adapter {

    private List<Newssearch.DataBean.NewListBean> newListBeans;
    private Context context;

    public MySearchAdapter(List<Newssearch.DataBean.NewListBean> newListBeans, Context context) {
        this.newListBeans = newListBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (newListBeans.get(position).getLayoutType().equals("2")) {
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
            holder1.tv.setText(newListBeans.get(position).getTitle());
            holder1.tv2.setText(newListBeans.get(position).getOrigin());
            holder1.tv3.setText(newListBeans.get(position).getPublishTime());
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder1.pic);
        }else{
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.tv.setText(newListBeans.get(position).getTitle());
            holder2.tv2.setText(newListBeans.get(position).getOrigin());
            holder2.tv3.setText(newListBeans.get(position).getPublishTime());
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder2.pic);
        }
    }

    @Override
    public int getItemCount() {
        return newListBeans.size();
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
