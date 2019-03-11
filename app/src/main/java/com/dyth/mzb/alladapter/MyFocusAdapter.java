package com.dyth.mzb.alladapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.my.base.focus.MyFocus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MyFocusAdapter extends RecyclerView.Adapter {

    private List<MyFocus.DataBean.FollowListBean> followListBeans;
    private Context context;
    private ItemClick mListener;

    public MyFocusAdapter(List<MyFocus.DataBean.FollowListBean> followListBeans, Context context) {
        this.followListBeans = followListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.focus_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        if(followListBeans.get(position).getFollowTime()!=null&&followListBeans.get(position).getHeadImagePath()!=null&&
                followListBeans.get(position).getNickname()!=null){
            Glide.with(context).load(followListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder1.focusHeadimg);
            holder1.foucsName.setText(followListBeans.get(position).getNickname());
            holder1.focusTime.setText(followListBeans.get(position).getFollowTime());
        }
        if(followListBeans.get(position).getPersonalProfile()!=null){
            holder1.foucsTitle.setText(followListBeans.get(position).getPersonalProfile().toString());
        }




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.ItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return followListBeans.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.focus_headimg)
        ImageView focusHeadimg;
        @BindView(R.id.foucs_name)
        TextView foucsName;
        @BindView(R.id.foucs_title)
        TextView foucsTitle;
        @BindView(R.id.focus_time)
        TextView focusTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface ItemClick{
        void ItemClick(View v,int position);
    }

    public void setOnItemClickListener(ItemClick onItemClickListener){
        this.mListener = onItemClickListener;
    }

}
