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
import com.dyth.mzb.my.base.morefocus.MoreFocusResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class MoreFocusAdapter extends RecyclerView.Adapter {


    private List<MoreFocusResponse.DataBean.MoreFollowListBean> moreFollowListBeans;
    private Context context;

    public MoreFocusAdapter(List<MoreFocusResponse.DataBean.MoreFollowListBean> moreFollowListBeans, Context context) {
        this.moreFollowListBeans = moreFollowListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.more_focus_item, null, false);
        return new ViewHolder(inflate) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        if(moreFollowListBeans!=null){
            if(moreFollowListBeans.get(position).getHeadImagePath()!=null
                    &&moreFollowListBeans.get(position).getNickname()!=null){

                holder1.moreName.setText(moreFollowListBeans.get(position).getNickname());
                holder1.moreNumber.setText(moreFollowListBeans.get(position).getFollowers()+"");
                Glide.with(context).load(moreFollowListBeans.get(position).getHeadImagePath()).into(holder1.moreHeadimg);
            }
        }
    }

    @Override
    public int getItemCount() {
        return moreFollowListBeans.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.more_headimg)
        ImageView moreHeadimg;
        @BindView(R.id.more_name)
        TextView moreName;
        @BindView(R.id.more_number)
        TextView moreNumber;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
