package com.dyth.mzb.my.base.notification;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/12.
 */

public class Notifation {

    @Override
    public String toString() {
        return "Notifation{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * data : [{"fromId":"","notifyContent":"http://www.baidu.com","notifyContentType":"0","notifyId":"a69af815566b11e8b64c00163e304111","notifyTime":"2018-05-13 16:11:16","notifyTitle":"测试系统通知","notifyType":"0","userId":"0"},{"fromId":"d4566f8f28634d67a2fedd69470fcca9","fromTitle":"测试话题图片压缩","fromType":"1","headImagePath":"http://39.107.224.233/firstga/images/head/2018-05-03/a9fba60a4a8f4413a3ae3d5de4010cbf_1525346287307.jpg","nickname":"Sophia","notifyId":"26f7beac566b11e8b64c00163e30445d","notifyTime":"2018-05-13 13:04:45","notifyTitle":"山西交汇处","notifyType":"2","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"},{"fromId":"366a7945cd6b406daa79d98d76f508eb","fromTitle":"测试话题图片压缩","fromType":"1","headImagePath":"http://39.107.224.233/firstga/images/head/2018-05-03/a9fba60a4a8f4413a3ae3d5de4010cbf_1525346287307.jpg","nickname":"Sophia","notifyId":"505b02d4566a11e8b64c00163e30445d","notifyTime":"2018-05-13 12:58:44","notifyType":"3","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"},{"fromId":"366a7945cd6b406daa79d98d76f508eb","fromTitle":"测试话题图片压缩","fromType":"1","headImagePath":"http://39.107.224.233/firstga/images/head/2018-05-03/a9fba60a4a8f4413a3ae3d5de4010cbf_1525346287307.jpg","nickname":"Sophia","notifyId":"4f00b3c4566a11e8b64c00163e30445d","notifyTime":"2018-05-13 12:58:42","notifyType":"2","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"},{"fromId":"af99be2557c64879959b75d4e13052b1","fromTitle":"哈哈细节成就精彩刺激成俊俊参考参考参考成俊俊刺激成俊疯狂聚聚聚聚家vjvjjvjvjvjvjvk笑口常开聚聚vjvjjvjvjfvjvjjvjj阶段进行检查","fromType":"1","headImagePath":"http://39.107.224.233/firstga/images/head/2018-05-03/a9fba60a4a8f4413a3ae3d5de4010cbf_1525346287307.jpg","nickname":"Sophia","notifyId":"a45819cf54f211e8b64c00163e30445d","notifyTime":"2018-05-11 16:09:35","notifyType":"3","userId":"a9fba60a4a8f4413a3ae3d5de4010cbf"}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "fromId='" + fromId + '\'' +
                    ", notifyContent='" + notifyContent + '\'' +
                    ", notifyContentType='" + notifyContentType + '\'' +
                    ", notifyId='" + notifyId + '\'' +
                    ", notifyTime='" + notifyTime + '\'' +
                    ", notifyTitle='" + notifyTitle + '\'' +
                    ", notifyType='" + notifyType + '\'' +
                    ", userId='" + userId + '\'' +
                    ", fromTitle='" + fromTitle + '\'' +
                    ", fromType='" + fromType + '\'' +
                    ", headImagePath='" + headImagePath + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }

        /**
         * fromId :
         * notifyContent : http://www.baidu.com
         * notifyContentType : 0
         * notifyId : a69af815566b11e8b64c00163e304111
         * notifyTime : 2018-05-13 16:11:16
         * notifyTitle : 测试系统通知
         * notifyType : 0
         * userId : 0
         * fromTitle : 测试话题图片压缩
         * fromType : 1
         * headImagePath : http://39.107.224.233/firstga/images/head/2018-05-03/a9fba60a4a8f4413a3ae3d5de4010cbf_1525346287307.jpg
         * nickname : Sophia
         */

        private String fromId;
        private String notifyContent;
        private String notifyContentType;
        private String notifyId;
        private String notifyTime;
        private String notifyTitle;
        private String notifyType;
        private String userId;
        private String fromTitle;
        private String fromType;
        private String headImagePath;
        private String nickname;

        public String getFromId() {
            return fromId;
        }

        public void setFromId(String fromId) {
            this.fromId = fromId;
        }

        public String getNotifyContent() {
            return notifyContent;
        }

        public void setNotifyContent(String notifyContent) {
            this.notifyContent = notifyContent;
        }

        public String getNotifyContentType() {
            return notifyContentType;
        }

        public void setNotifyContentType(String notifyContentType) {
            this.notifyContentType = notifyContentType;
        }

        public String getNotifyId() {
            return notifyId;
        }

        public void setNotifyId(String notifyId) {
            this.notifyId = notifyId;
        }

        public String getNotifyTime() {
            return notifyTime;
        }

        public void setNotifyTime(String notifyTime) {
            this.notifyTime = notifyTime;
        }

        public String getNotifyTitle() {
            return notifyTitle;
        }

        public void setNotifyTitle(String notifyTitle) {
            this.notifyTitle = notifyTitle;
        }

        public String getNotifyType() {
            return notifyType;
        }

        public void setNotifyType(String notifyType) {
            this.notifyType = notifyType;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFromTitle() {
            return fromTitle;
        }

        public void setFromTitle(String fromTitle) {
            this.fromTitle = fromTitle;
        }

        public String getFromType() {
            return fromType;
        }

        public void setFromType(String fromType) {
            this.fromType = fromType;
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
    }
}
