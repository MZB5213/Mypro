package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.infomation.beans.comments.CommentsList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class CollectionAdapter extends RecyclerView.Adapter {

    private List<CommentsList.DataBean.CommentListBean> commentListBeans;
    private Context context;

    public CollectionAdapter(List<CommentsList.DataBean.CommentListBean> commentListBeans, Context context) {
        this.commentListBeans = commentListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.comments_list, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       if(commentListBeans.get(position).getContent()!=null) {
           ViewHolder holder1 = (ViewHolder) holder;
           holder1.tv.setText("热门评论" + commentListBeans.get(position).getContent().length() + "条");
            holder1.tv4.setText(commentListBeans.get(position).getContent());
       }
    }

    @Override
    public int getItemCount() {
        if (commentListBeans == null) {
            return 0;
        }
        return commentListBeans.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.tv4)
        TextView tv4;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
