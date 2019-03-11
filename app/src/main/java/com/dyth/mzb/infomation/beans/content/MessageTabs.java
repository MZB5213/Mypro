package com.dyth.mzb.infomation.beans.content;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class MessageTabs {


    @Override
    public String toString() {
        return "MessageTabs{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : {"newsChannelList":[{"channelId":"b93dcb5d3b0211e8b64c00163e30445d","channelName":"飞行运动"}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "newsChannelList=" + newsChannelList +
                    '}';
        }

        private List<NewsChannelListBean> newsChannelList;

        public List<NewsChannelListBean> getNewsChannelList() {
            return newsChannelList;
        }

        public void setNewsChannelList(List<NewsChannelListBean> newsChannelList) {
            this.newsChannelList = newsChannelList;
        }

        public static class NewsChannelListBean {
            /**
             * channelId : b93dcb5d3b0211e8b64c00163e30445d
             * channelName : 飞行运动
             */

            private String channelId;
            private String channelName;

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }
        }
    }
}
