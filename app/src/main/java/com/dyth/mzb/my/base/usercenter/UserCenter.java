package com.dyth.mzb.my.base.usercenter;

import java.io.Serializable;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UserCenter implements Serializable {

    @Override
    public String toString() {
        return "UserCenter{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 登录成功
     * data : {"comments":0,"favorites":0,"following":0,"headImagePath":null,"historyReads":0,"isWifiImages":0,"nickname":null,"personalProfile":null,"phone":"18301413850","unMessages":0,"userId":"d56ea66e7ee741f498ca51242c8c6394"}
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
                    "comments=" + comments +
                    ", favorites=" + favorites +
                    ", following=" + following +
                    ", headImagePath=" + headImagePath +
                    ", historyReads=" + historyReads +
                    ", isWifiImages=" + isWifiImages +
                    ", nickname=" + nickname +
                    ", personalProfile=" + personalProfile +
                    ", phone='" + phone + '\'' +
                    ", unMessages=" + unMessages +
                    ", userId='" + userId + '\'' +
                    '}';
        }

        /**
         * comments : 0
         * favorites : 0
         * following : 0
         * headImagePath : null
         * historyReads : 0
         * isWifiImages : 0
         * nickname : null
         * personalProfile : null
         * phone : 18301413850
         * unMessages : 0
         * userId : d56ea66e7ee741f498ca51242c8c6394
         */

        private int comments;
        private int favorites;
        private int following;
        private Object headImagePath;
        private int historyReads;
        private int isWifiImages;
        private Object nickname;
        private Object personalProfile;
        private String phone;
        private int unMessages;
        private String userId;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public Object getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(Object headImagePath) {
            this.headImagePath = headImagePath;
        }

        public int getHistoryReads() {
            return historyReads;
        }

        public void setHistoryReads(int historyReads) {
            this.historyReads = historyReads;
        }

        public int getIsWifiImages() {
            return isWifiImages;
        }

        public void setIsWifiImages(int isWifiImages) {
            this.isWifiImages = isWifiImages;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public Object getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(Object personalProfile) {
            this.personalProfile = personalProfile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getUnMessages() {
            return unMessages;
        }

        public void setUnMessages(int unMessages) {
            this.unMessages = unMessages;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
