package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.my.base.feedback.MyFeedBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBackAdapter extends RecyclerView.Adapter {
    private List<MyFeedBack.DataBean> dataBeans;
    private Context context;

    public FeedBackAdapter(List<MyFeedBack.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.feedback_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.textTv1.setText(dataBeans.get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_tv1)
        TextView textTv1;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
