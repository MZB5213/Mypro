package com.dyth.mzb.my.base.focus;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MyFocus {

    @Override
    public String toString() {
        return "MyFocus{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : {"followList":[{"followId":"a9fba60a4a8e4010cbf","followTime":"2018-04-26 17:45:23","followUid":"a9fba60a4a8e4010cbf","headImagePath":"/hea1524732343313.jpg","nickname":"李瑛彬","personalProfile":null}]}
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
                    "followList=" + followList +
                    '}';
        }

        private List<FollowListBean> followList;

        public List<FollowListBean> getFollowList() {
            return followList;
        }

        public void setFollowList(List<FollowListBean> followList) {
            this.followList = followList;
        }

        public static class FollowListBean {
            @Override
            public String toString() {
                return "FollowListBean{" +
                        "followId='" + followId + '\'' +
                        ", followTime='" + followTime + '\'' +
                        ", followUid='" + followUid + '\'' +
                        ", headImagePath='" + headImagePath + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", personalProfile=" + personalProfile +
                        '}';
            }

            /**
             * followId : a9fba60a4a8e4010cbf
             * followTime : 2018-04-26 17:45:23
             * followUid : a9fba60a4a8e4010cbf
             * headImagePath : /hea1524732343313.jpg
             * nickname : 李瑛彬
             * personalProfile : null
             */

            private String followId;
            private String followTime;
            private String followUid;
            private String headImagePath;
            private String nickname;
            private Object personalProfile;

            public String getFollowId() {
                return followId;
            }

            public void setFollowId(String followId) {
                this.followId = followId;
            }

            public String getFollowTime() {
                return followTime;
            }

            public void setFollowTime(String followTime) {
                this.followTime = followTime;
            }

            public String getFollowUid() {
                return followUid;
            }

            public void setFollowUid(String followUid) {
                this.followUid = followUid;
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

            public Object getPersonalProfile() {
                return personalProfile;
            }

            public void setPersonalProfile(Object personalProfile) {
                this.personalProfile = personalProfile;
            }
        }
    }
}
