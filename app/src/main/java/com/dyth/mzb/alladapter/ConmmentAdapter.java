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
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.my.base.MyCOM.MyCOM;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class ConmmentAdapter extends RecyclerView.Adapter {

    private List<MyCOM.DataBean.UserCommentListBean> userCommentListBeans;
    private Context context;

    public ConmmentAdapter(List<MyCOM.DataBean.UserCommentListBean> userCommentListBeans, Context context) {
        this.userCommentListBeans = userCommentListBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.zx_moreimg, null, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.zx_oneimg, null, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(userCommentListBeans.get(position).getObjectType().equals("1")){
            if(getItemViewType(position)==1) {
                ViewHolder holder1 = (ViewHolder) holder;
                Glide.with(context).load(R.mipmap.msc).apply(new RequestOptions().circleCrop()).into(holder1.topicHeadimg);
                holder1.tv.setText(userCommentListBeans.get(position).getTitle());
                holder1.tv2.setText(userCommentListBeans.get(position).getCommentTime());
                holder1.tv3.setText(userCommentListBeans.get(position).getContent());
            }else{
                ViewHolder2 holder2 = (ViewHolder2) holder;
                Glide.with(context).load(R.mipmap.msc).apply(new RequestOptions().circleCrop()).into(holder2.topicHeadimg);
                holder2.tv.setText(userCommentListBeans.get(position).getTitle());
                holder2.tv2.setText(userCommentListBeans.get(position).getCommentTime());
                holder2.tv3.setText(userCommentListBeans.get(position).getContent());

            }
        }

    }

    @Override
    public int getItemCount() {
        return userCommentListBeans.size();
    }



     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        ImageView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.pic2)
        ImageView pic2;
        @BindView(R.id.pic3)
        ImageView pic3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        ImageView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.pic)
        ImageView pic;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
