package com.dyth.mzb.infomation.beans.topicsearch;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/2.
 */

public class TopicSearch {


    /**
     * code : 0
     * message : 成功
     * data : {"cursor":"2","topicList":[{"comments":0,"headImagePath":"/head/2018-04-580.png","imageListThumb":["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg"],"likes":0,"nickname":"李红梅","pageviews":0,"publishTime":"2018-04-29 10:15:40","shareLink":"http://www.baidu.com","title":"postman测试发布话题","topicId":"452faafc1bfe4f0585be52255c10748e","userId":"d56ea66e7ee741f498ca51242c8c6394"}]}
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
         * cursor : 2
         * topicList : [{"comments":0,"headImagePath":"/head/2018-04-580.png","imageListThumb":["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg"],"likes":0,"nickname":"李红梅","pageviews":0,"publishTime":"2018-04-29 10:15:40","shareLink":"http://www.baidu.com","title":"postman测试发布话题","topicId":"452faafc1bfe4f0585be52255c10748e","userId":"d56ea66e7ee741f498ca51242c8c6394"}]
         */

        private String cursor;
        private List<TopicListBean> topicList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<TopicListBean> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<TopicListBean> topicList) {
            this.topicList = topicList;
        }

        public static class TopicListBean {
            /**
             * comments : 0
             * headImagePath : /head/2018-04-580.png
             * imageListThumb : ["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg"]
             * likes : 0
             * nickname : 李红梅
             * pageviews : 0
             * publishTime : 2018-04-29 10:15:40
             * shareLink : http://www.baidu.com
             * title : postman测试发布话题
             * topicId : 452faafc1bfe4f0585be52255c10748e
             * userId : d56ea66e7ee741f498ca51242c8c6394
             */

            private int comments;
            private String headImagePath;
            private int likes;
            private String nickname;
            private int pageviews;
            private String publishTime;
            private String shareLink;
            private String title;
            private String topicId;
            private String userId;
            private List<String> imageListThumb;

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public String getHeadImagePath() {
                return headImagePath;
            }

            public void setHeadImagePath(String headImagePath) {
                this.headImagePath = headImagePath;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPageviews() {
                return pageviews;
            }

            public void setPageviews(int pageviews) {
                this.pageviews = pageviews;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getShareLink() {
                return shareLink;
            }

            public void setShareLink(String shareLink) {
                this.shareLink = shareLink;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTopicId() {
                return topicId;
            }

            public void setTopicId(String topicId) {
                this.topicId = topicId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
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
