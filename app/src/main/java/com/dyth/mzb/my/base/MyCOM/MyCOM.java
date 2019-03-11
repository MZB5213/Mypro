package com.dyth.mzb.my.base.MyCOM;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class MyCOM {


    @Override
    public String toString() {
        return "MyCOM{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : {"userCommentList":[{"commentId":"302836c6e0504728aa455f901184771c","commentTime":"2018-05-02 16:30:35","content":"评论测试","objectId":"94231a0dc3da465297b2b5d3df15cc09","objectType":"1","title":"哈哈"}]}
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
                    "userCommentList=" + userCommentList +
                    '}';
        }

        private List<UserCommentListBean> userCommentList;

        public List<UserCommentListBean> getUserCommentList() {
            return userCommentList;
        }

        public void setUserCommentList(List<UserCommentListBean> userCommentList) {
            this.userCommentList = userCommentList;
        }

        public static class UserCommentListBean {
            @Override
            public String toString() {
                return "UserCommentListBean{" +
                        "commentId='" + commentId + '\'' +
                        ", commentTime='" + commentTime + '\'' +
                        ", content='" + content + '\'' +
                        ", objectId='" + objectId + '\'' +
                        ", objectType='" + objectType + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }

            /**
             * commentId : 302836c6e0504728aa455f901184771c
             * commentTime : 2018-05-02 16:30:35
             * content : 评论测试
             * objectId : 94231a0dc3da465297b2b5d3df15cc09
             * objectType : 1
             * title : 哈哈
             */


            private String commentId;
            private String commentTime;
            private String content;
            private String objectId;
            private String objectType;
            private String title;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(String commentTime) {
                this.commentTime = commentTime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public String getObjectType() {
                return objectType;
            }

            public void setObjectType(String objectType) {
                this.objectType = objectType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
