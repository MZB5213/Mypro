package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.infomation.beans.Collection.Collection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Lenovo on 2019/1/4.
 */

public class CollectionListAdapter extends RecyclerView.Adapter {

    public List<Collection.DataBean.FavouritNewsListBean> favouritNewsListBeans;
    private Context context;
    private OnItemClick mListener;
    private Boolean flag = true;
    public List<Collection.DataBean.FavouritNewsListBean> newfavouritNewsList = new ArrayList<>();

    private View inflate;
    private boolean data;

    public CollectionListAdapter(List<Collection.DataBean.FavouritNewsListBean> favouritNewsListBeans, Context context) {
        this.favouritNewsListBeans = favouritNewsListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.collection_item, null, false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder holder1 = (ViewHolder) holder;
        if (favouritNewsListBeans.get(position).getTitle() != null) {
            holder1.my_title.setText(favouritNewsListBeans.get(position).getTitle().toString());
        } else {
            favouritNewsListBeans.remove(position);
        }

        if(favouritNewsListBeans.get(position).getIschead()){
            holder1.yn_switch.setVisibility(View.GONE);
        }else{
            holder1.yn_switch.setVisibility(View.VISIBLE);
        }

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnClick(v, position);
                    if(flag){
                        holder1.yn_switch.setChecked(true);
                        newfavouritNewsList.add(favouritNewsListBeans.get(position));
                        flag = false;
                    }else{
                        holder1.yn_switch.setChecked(false);
                        flag = true;
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return favouritNewsListBeans.size();
    }

    public void setData(boolean data) {
        this.data = data;

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.my_title)
        TextView my_title;
        @BindView(R.id.yn_switch)
        CheckBox yn_switch;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClick {
        void OnClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClick itemClickListener) {
        this.mListener = itemClickListener;
    }
}
