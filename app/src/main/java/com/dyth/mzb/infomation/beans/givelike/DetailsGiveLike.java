package com.dyth.mzb.infomation.beans.givelike;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class DetailsGiveLike {


    /**
     * code : 0
     * message : 成功
     * data : {"comments":0,"content":"<div class=\"content\">n\t\t\t<\/div>","isFavoured":0,"isLiked":0,"newsId":"0011adc699094f67b8b6ed8837173a7e","origin":"中国通航网 ","publishTime":"2018-04-16","title":"红钻航空以91部运行 业务升级助推多元化"}
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
         * comments : 0
         * content : <div class="content">n			</div>
         * isFavoured : 0
         * isLiked : 0
         * newsId : 0011adc699094f67b8b6ed8837173a7e
         * origin : 中国通航网
         * publishTime : 2018-04-16
         * title : 红钻航空以91部运行 业务升级助推多元化
         */

        private int comments;
        private String content;
        private int isFavoured;
        private int isLiked;
        private String newsId;
        private String origin;
        private String publishTime;
        private String title;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIsFavoured() {
            return isFavoured;
        }

        public void setIsFavoured(int isFavoured) {
            this.isFavoured = isFavoured;
        }

        public int getIsLiked() {
            return isLiked;
        }

        public void setIsLiked(int isLiked) {
            this.isLiked = isLiked;
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
    }
}
