package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.beans.thelabel.TheLableResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class ThelabelAdapter extends RecyclerView.Adapter {

    private List<Newssearch.DataBean.NewListBean> newListBeans;
    private Context context;

    public ThelabelAdapter(List<Newssearch.DataBean.NewListBean> newListBeans, Context context) {
        this.newListBeans = newListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_adapter, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv.setText(newListBeans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (newListBeans==null){
            return 0;
        }
        return newListBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
