package com.dyth.mzb.my.base.aboutus;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class AboutUs {

    @Override
    public String toString() {
        return "AboutUs{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : {"aboutUs":"<p class=\"MsoNormalzm61MpG90/PoSWz","createTime":"2018-05-14 17:07:43","id":"0eb21563829642dcadb97d607f0f29ba"}
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
                    "aboutUs='" + aboutUs + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        /**
         * aboutUs : <p class="MsoNormalzm61MpG90/PoSWz
         * createTime : 2018-05-14 17:07:43
         * id : 0eb21563829642dcadb97d607f0f29ba
         */


        private String aboutUs;
        private String createTime;
        private String id;

        public String getAboutUs() {
            return aboutUs;
        }

        public void setAboutUs(String aboutUs) {
            this.aboutUs = aboutUs;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
