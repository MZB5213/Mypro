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
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.topic.bean.MyTopic;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/9.
 */

public class TopicAdapter extends RecyclerView.Adapter {

    private List<MyTopic.DataBean.TopicListBean> topicListBeans;
    private Context context;

    public TopicAdapter(List<MyTopic.DataBean.TopicListBean> topicListBeans, Context context) {
        this.topicListBeans = topicListBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%3==0) {
            return 1;
        } else if (position%3==1) {
            return 2;
        } else {
            return 3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_moreimg, null, false);
            return new ViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_big, null, false);
            return new ViewHolder2(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_url, null, false);
            return new ViewHolder3(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
      if(topicListBeans!=null){
          if(itemViewType==1){
              ViewHolder holder1 = (ViewHolder) holder;
              Glide.with(context).load(topicListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder1.topicHeadimg);

              if(topicListBeans.get(position).getImageListThumb()!=null){
                  Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(0)).into(holder1.pic);
                  //Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(1)).into(holder1.pic2);
                  //Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(2)).into(holder1.pic3);
              }
              holder1.tv.setText(topicListBeans.get(position).getNickname());
              holder1.tv2.setText(topicListBeans.get(position).getPublishTime());
              holder1.tv3.setText(topicListBeans.get(position).getTitle());
              holder1.number1.setText(topicListBeans.get(position).getPageviews()+"");
              holder1.number2.setText(topicListBeans.get(position).getComments()+"");
              holder1.number3.setText(topicListBeans.get(position).getLikes()+"");
          }else if(itemViewType==2){
              ViewHolder2 holder2 = (ViewHolder2) holder;
              if(topicListBeans.get(position).getImageListThumb()!=null){
                  Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(0)).into(holder2.pic);
              }
              Glide.with(context).load(topicListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder2.topicHeadimg);
              holder2.tv.setText(topicListBeans.get(position).getNickname());
              holder2.tv2.setText(topicListBeans.get(position).getPublishTime());
              holder2.tv3.setText(topicListBeans.get(position).getTitle());
              holder2.number1.setText(topicListBeans.get(position).getPageviews()+"");
              holder2.number2.setText(topicListBeans.get(position).getComments()+"");
              holder2.number3.setText(topicListBeans.get(position).getLikes()+"");
          }else{
              ViewHolder3 holder3 = (ViewHolder3) holder;
              Glide.with(context).load(topicListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder3.topicHeadimg);
              if(topicListBeans.get(position).getImageListThumb()!=null){
                  Glide.with(context).load(topicListBeans.get(position).getImageListThumb().get(0)).into(holder3.pic);
              }
              holder3.tv.setText(topicListBeans.get(position).getNickname());
              holder3.tv2.setText(topicListBeans.get(position).getPublishTime());
              holder3.tv3.setText(topicListBeans.get(position).getTitle());
              holder3.title.setText(topicListBeans.get(position).getTitle());
              holder3.number1.setText(topicListBeans.get(position).getPageviews()+"");
              holder3.number2.setText(topicListBeans.get(position).getComments()+"");
              holder3.number3.setText(topicListBeans.get(position).getLikes()+"");
          }
      }

    }

    @Override
    public int getItemCount() {
        if(topicListBeans==null){
            return 0;
        }
        return topicListBeans.size();
    }





     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        ImageView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        ImageView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
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

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_headimg)
        ImageView topicHeadimg;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.number1)
        TextView number1;
        @BindView(R.id.number2)
        TextView number2;
        @BindView(R.id.number3)
        TextView number3;

        ViewHolder3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
