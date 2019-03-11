package com.dyth.mzb.alladapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dyth.mzb.R;
import com.dyth.mzb.my.base.topiccollection.Topic;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/12.
 */

public class MyTopicAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<Topic.DataBean.FavouritTopicListBean> favouritTopicListBeans;
    private Context context;
    private OnClick mListener;
    private PopupWindow popupWindow;

    public MyTopicAdapter(List<Topic.DataBean.FavouritTopicListBean> favouritTopicListBeans, Context context) {
        this.favouritTopicListBeans = favouritTopicListBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (favouritTopicListBeans.get(position).getImageListThumb() == null) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.my_topicbig, null, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.my_topicmor, null, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        final ViewHolder holder1 = (ViewHolder) holder;

        if(itemViewType==1){
            holder1.topicHeadimg.setText(favouritTopicListBeans.get(position).getPublishTime());
            holder1.tv3.setText(favouritTopicListBeans.get(position).getTitle());
            holder1.number1.setText(favouritTopicListBeans.get(position).getPageviews()+"");
            holder1.number2.setText(favouritTopicListBeans.get(position).getComments()+"");
            holder1.number3.setText(favouritTopicListBeans.get(position).getLikes()+"");
        }else{
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(0)).into(holder2.pic);
            Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(1)).into(holder2.pic2);
            Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(2)).into(holder2.pic3);
            holder2.topicHeadimg.setText(favouritTopicListBeans.get(position).getPublishTime());
            holder2.tv3.setText(favouritTopicListBeans.get(position).getTitle());
            holder2.number1.setText(favouritTopicListBeans.get(position).getPageviews()+"");
            holder2.number2.setText(favouritTopicListBeans.get(position).getComments()+"");
            holder2.number3.setText(favouritTopicListBeans.get(position).getLikes()+"");
        }

        final View inflate = LayoutInflater.from(context).inflate(R.layout.my_pop, null, false);
        popupWindow = new PopupWindow(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        TextView updata = inflate.findViewById(R.id.updata);
        TextView delete = inflate.findViewById(R.id.delete);
        TextView copy = inflate.findViewById(R.id.copy);
        TextView cancel = inflate.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        delete.setOnClickListener(this);
        cancel.setOnClickListener(this);
        updata.setOnClickListener(this);
        copy.setOnClickListener(this);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.ItemClick(v,position);
                    holder1.tv.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onClick(View v) {
                           popupWindow.showAtLocation(inflate,Gravity.BOTTOM,0,0);
                        }
                    });
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if(favouritTopicListBeans==null){
            return 0;
        }
        return favouritTopicListBeans.size();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.updata:

                break;
            case R.id.delete:

                break;
            case R.id.copy:

                break;
            case R.id.cancel:
                popupWindow.dismiss();
                break;
        }

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        TextView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.number1)
        TextView number1;
        @BindView(R.id.number2)
        TextView number2;
        @BindView(R.id.number3)
        TextView number3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        TextView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.pic2)
        ImageView pic2;
        @BindView(R.id.pic3)
        ImageView pic3;
        @BindView(R.id.number1)
        TextView number1;
        @BindView(R.id.number2)
        TextView number2;
        @BindView(R.id.number3)
        TextView number3;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnClick{
        void ItemClick(View v,int position);
    }

    public void setOnItemClickListener(OnClick itemClickListener){
        this.mListener = itemClickListener;
    }

}
