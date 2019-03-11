package com.dyth.mzb.alladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.my.base.notification.Notifation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/13.
 */

public class NotifationoneAdapter extends RecyclerView.Adapter {

    private List<Notifation.DataBean> dataBeans;
    private Context context;
    private List<String> list;

//    public NotifationoneAdapter(List<String> list,Context context) {
//        this.context = context;
//        this.list = list;
//    }

    public NotifationoneAdapter(List<Notifation.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.notifation_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//            list = new ArrayList<>();
//            list.add(dataBeans.size()+"");
//            Log.e(dataBeans.size()+"","-=-==--=-==-=-=-=-");
//            ViewHolder holder1 = (ViewHolder) holder;
//            holder1.textNumber.setText(dataBeans.size()+"");
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.textTitle.setText(dataBeans.get(position).getNotifyTitle());
            holder1.textBody.setText(dataBeans.get(position).getFromTitle());
            holder1.textTime.setText(dataBeans.get(position).getNotifyTime());
            Glide.with(context).load(dataBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder1.notHeadimg);



    }

    @Override
    public int getItemCount() {
        if(dataBeans==null) {
            return 0;
        }
        return dataBeans.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.not_headimg)
        ImageView notHeadimg;
        @BindView(R.id.text_title)
         TextView textTitle;
         @BindView(R.id.text_body)
         TextView textBody;
         @BindView(R.id.text_time)
         TextView textTime;
         @BindView(R.id.text_number)
         TextView textNumber;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }



}
