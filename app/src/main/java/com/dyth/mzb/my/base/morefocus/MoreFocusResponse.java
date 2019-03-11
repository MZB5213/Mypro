package com.dyth.mzb.my.base.morefocus;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class MoreFocusResponse {

    @Override
    public String toString() {
        return "MoreFocusResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : {"cursor":"0","moreFollowList":[{"followers":0,"headImagePath":"http://39.107.1525346287307.jpg","nickname":"李瑛彬","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"}]}
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
                    "cursor='" + cursor + '\'' +
                    ", moreFollowList=" + moreFollowList +
                    '}';
        }

        /**
         * cursor : 0
         * moreFollowList : [{"followers":0,"headImagePath":"http://39.107.1525346287307.jpg","nickname":"李瑛彬","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"}]
         */

        private String cursor;
        private List<MoreFollowListBean> moreFollowList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<MoreFollowListBean> getMoreFollowList() {
            return moreFollowList;
        }

        public void setMoreFollowList(List<MoreFollowListBean> moreFollowList) {
            this.moreFollowList = moreFollowList;
        }

        public static class MoreFollowListBean {
            @Override
            public String toString() {
                return "MoreFollowListBean{" +
                        "followers=" + followers +
                        ", headImagePath='" + headImagePath + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", userId='" + userId + '\'' +
                        '}';
            }

            /**
             * followers : 0
             * headImagePath : http://39.107.1525346287307.jpg
             * nickname : 李瑛彬
             * userId : a9fba60a4a8f4413a3ae3d5de4010cbf
             */


            private int followers;
            private String headImagePath;
            private String nickname;
            private String userId;

            public int getFollowers() {
                return followers;
            }

            public void setFollowers(int followers) {
                this.followers = followers;
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
