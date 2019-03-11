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
import com.dyth.mzb.infomation.beans.content.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class InfoRlvAdapter extends RecyclerView.Adapter {

    private List<Message.DataBean.NewListBean> newListBeans;
    private Context context;
    private OnClick mListener;

    public InfoRlvAdapter(List<Message.DataBean.NewListBean> newListBeans, Context context) {
        this.newListBeans = newListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.noimg, null, false);
            return new ViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.smallimg, null, false);
            return new ViewHolder2(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.moreimg, null, false);
            return new ViewHolder3(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.bigimg, null, false);
            return new ViewHolder4(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.tv.setText(newListBeans.get(position).getTitle());
            holder1.tv2.setText(newListBeans.get(position).getPublishTime());
            holder1.tv3.setText(newListBeans.get(position).getOrigin());
        }else if(itemViewType==2){
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.tv.setText(newListBeans.get(position).getTitle());
            holder2.tv2.setText(newListBeans.get(position).getPublishTime());
            holder2.tv3.setText(newListBeans.get(position).getOrigin());
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder2.pic);
        }else if(itemViewType==3){
            ViewHolder3 holder3 = (ViewHolder3) holder;
            holder3.tv.setText(newListBeans.get(position).getTitle());
            holder3.tv2.setText(newListBeans.get(position).getPublishTime());
            holder3.tv3.setText(newListBeans.get(position).getOrigin());
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder3.pic);
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder3.pic2);
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder3.pic3);
        }else{
            ViewHolder4 holder4 = (ViewHolder4) holder;
            holder4.tv.setText(newListBeans.get(position).getTitle());
            holder4.tv2.setText(newListBeans.get(position).getPublishTime());
            holder4.tv3.setText(newListBeans.get(position).getOrigin());
            Glide.with(context).load(newListBeans.get(position).getImageListThumb().get(0)).into(holder4.pic);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.OnItemClick(v,position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mListener!=null){
                    mListener.OnItemLongClick(v,position);
                }

                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return newListBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (newListBeans.get(position).getLayoutType().equals("0")) {
            return 1;
        } else if (newListBeans.get(position).getLayoutType().equals("1")) {
            return 2;
        } else if (newListBeans.get(position).getLayoutType().equals("2")) {
            return 3;
        } else {
            return 4;
        }
    }




     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
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

    class ViewHolder3 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.pic2)
        ImageView pic2;
        @BindView(R.id.pic3)
        ImageView pic3;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;

        ViewHolder3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {
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

        ViewHolder4(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public interface OnClick{
        void OnItemClick(View v,int position);
        void OnItemLongClick(View v,int position);
    }

    public void setOnItemCLick(OnClick onItemCLick){
        this.mListener = onItemCLick;
    }

}
