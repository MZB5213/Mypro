package com.dyth.mzb.infomation.beans.comments;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsList {


    /**
     * code : 0
     * data : {"commentList":[{"commentTime":"2018-05-02 16:30:35","content":"评论测试","headImagePath":"http://39._1524733107580.png","nickname":"李红梅","userId":"d56ea66e7ee741f498ca51242c8c6394"}],"cursor":"0"}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * commentList : [{"commentTime":"2018-05-02 16:30:35","content":"评论测试","headImagePath":"http://39._1524733107580.png","nickname":"李红梅","userId":"d56ea66e7ee741f498ca51242c8c6394"}]
         * cursor : 0
         */

        private String cursor;
        private List<CommentListBean> commentList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<CommentListBean> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<CommentListBean> commentList) {
            this.commentList = commentList;
        }

        public static class CommentListBean {
            /**
             * commentTime : 2018-05-02 16:30:35
             * content : 评论测试
             * headImagePath : http://39._1524733107580.png
             * nickname : 李红梅
             * userId : d56ea66e7ee741f498ca51242c8c6394
             */

            private String commentTime;
            private String content;
            private String headImagePath;
            private String nickname;
            private String userId;

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

            public String getHeadImagePath() {
                return headImagePath;
            }

            public void setHeadImagePath(String headImagePath) {
                this.headImagePath = headImagePath;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }
        }
    }
}
