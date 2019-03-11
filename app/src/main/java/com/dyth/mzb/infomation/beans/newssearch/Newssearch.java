package com.dyth.mzb.infomation.beans.newssearch;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/29.
 */

public class Newssearch {


    /**
     * code : 0
     * message : 成功
     * data : {"cursor":"150902280603b383eb34314a348cfc3a3bd35286a7","newList":[{"comments":0,"imageListThumb":["http://www.ga.cn/uploads/allimg/180416/1_180416083714_1-lp.png"],"layoutType":"1","newsId":"0011adc699094f67b8b6ed8837173a7e","origin":"中国通航网 ","publishTime":"2018-04-16","title":"红钻航空以91部运行 业务升级助推多元化"}]}
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
        /**
         * cursor : 150902280603b383eb34314a348cfc3a3bd35286a7
         * newList : [{"comments":0,"imageListThumb":["http://www.ga.cn/uploads/allimg/180416/1_180416083714_1-lp.png"],"layoutType":"1","newsId":"0011adc699094f67b8b6ed8837173a7e","origin":"中国通航网 ","publishTime":"2018-04-16","title":"红钻航空以91部运行 业务升级助推多元化"}]
         */

        private String cursor;
        private List<NewListBean> newList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<NewListBean> getNewList() {
            return newList;
        }

        public void setNewList(List<NewListBean> newList) {
            this.newList = newList;
        }

        public static class NewListBean {
            /**
             * comments : 0
             * imageListThumb : ["http://www.ga.cn/uploads/allimg/180416/1_180416083714_1-lp.png"]
             * layoutType : 1
             * newsId : 0011adc699094f67b8b6ed8837173a7e
             * origin : 中国通航网
             * publishTime : 2018-04-16
             * title : 红钻航空以91部运行 业务升级助推多元化
             */

            private int comments;
            private String layoutType;
            private String newsId;
            private String origin;
            private String publishTime;
            private String title;
            private List<String> imageListThumb;

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public String getLayoutType() {
                return layoutType;
            }

            public void setLayoutType(String layoutType) {
                this.layoutType = layoutType;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<String> getImageListThumb() {
                return imageListThumb;
            }

            public void setImageListThumb(List<String> imageListThumb) {
                this.imageListThumb = imageListThumb;
            }
        }
    }
}
