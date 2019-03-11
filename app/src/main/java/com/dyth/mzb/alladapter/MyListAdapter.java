package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.infomation.beans.newssearch.HotNewssearch;
import com.dyth.mzb.infomation.beans.thelabel.HotThelable;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class MyListAdapter extends RecyclerView.Adapter {

    private List<HotNewssearch.DataBean.SearchListBean> dataBeans;
    private Context context;

    public MyListAdapter(List<HotNewssearch.DataBean.SearchListBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
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
        holder1.tv.setText(dataBeans.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
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
