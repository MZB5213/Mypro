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
import com.dyth.mzb.my.base.topiccollection.TopicCollection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MyTopicCollectionAdapter extends RecyclerView.Adapter {

    private List<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicListBeans;
    private Context context;
    private OnItemCick mListener;
    private boolean topicflag;
    private Boolean flag;

    @Override
    public int getItemViewType(int position) {
        if (favouritTopicListBeans.get(position).getImageListThumb()!=null&&favouritTopicListBeans.get(position).getImageListThumb().size() == 3) {
            return 1;
        } else {
            return 2;
        }
    }

    public MyTopicCollectionAdapter(List<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicListBeans, Context context) {
        this.favouritTopicListBeans = favouritTopicListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_item, null, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_item2, null, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            if(favouritTopicListBeans.get(position).getTitle()!=null&&favouritTopicListBeans.get(position).getHeadImagePath()!=null
                    &&favouritTopicListBeans.get(position).getNickname()!=null
                    ) {
                ViewHolder holder1 = (ViewHolder) holder;
                Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(0)).into(holder1.topicPic1);
                Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(1)).into(holder1.topicPic2);
                Glide.with(context).load(favouritTopicListBeans.get(position).getImageListThumb().get(2)).into(holder1.topicPic3);
                Glide.with(context).load(favouritTopicListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder1.topicHeadimg);
                holder1.topicName.setText(favouritTopicListBeans.get(position).getNickname());
                holder1.topicTime.setText(favouritTopicListBeans.get(position).getPublishTime());
                holder1.topicTitle.setText(favouritTopicListBeans.get(position).getTitle());
            }
        }else{
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Glide.with(context).load(favouritTopicListBeans.get(position).getHeadImagePath()).into(holder2.topicPic1);
            Glide.with(context).load(favouritTopicListBeans.get(position).getHeadImagePath()).apply(new RequestOptions().circleCrop()).into(holder2.topicHeadimg);
            holder2.topicName.setText(favouritTopicListBeans.get(position).getNickname());
            holder2.topicTime.setText(favouritTopicListBeans.get(position).getPublishTime());
            holder2.topicTitle.setText(favouritTopicListBeans.get(position).getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return favouritTopicListBeans.size();
    }

    public void setData(boolean topicflag) {
        this.topicflag = topicflag;
    }


    public interface OnItemCick {
        void OnClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemCick onItemClickListener) {
        this.mListener = onItemClickListener;
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView topicHeadimg;
        private final ImageView topicPic1;
        private final ImageView topicPic2;
        private final ImageView topicPic3;
        private final TextView topicName;
        private final TextView topicTime;
        private final TextView topicTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            topicHeadimg = itemView.findViewById(R.id.topic_headimg);
            topicPic1 = itemView.findViewById(R.id.topic_pic1);
            topicPic2 = itemView.findViewById(R.id.topic_pic2);
            topicPic3 = itemView.findViewById(R.id.topic_pic3);
            topicName = itemView.findViewById(R.id.topic_name);
            topicTime = itemView.findViewById(R.id.topic_time);
            topicTitle = itemView.findViewById(R.id.topic_title);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView topicHeadimg;
        private final ImageView topicPic1;
        private final TextView topicName;
        private final TextView topicTime;
        private final TextView topicTitle;
        private final TextView topicTitle2;

        public ViewHolder2(View itemView) {
            super(itemView);
            topicHeadimg = itemView.findViewById(R.id.topic_headimg);
            topicPic1 = itemView.findViewById(R.id.topic_pic1);
            topicName = itemView.findViewById(R.id.topic_name);
            topicTime = itemView.findViewById(R.id.topic_time);
            topicTitle = itemView.findViewById(R.id.topic_title);
            topicTitle2 = itemView.findViewById(R.id.topic_title2);
        }
    }
}
