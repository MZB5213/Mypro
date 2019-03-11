package com.dyth.mzb.my.base.upload;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UpLoadHeader {

    @Override
    public String toString() {
        return "UpLoadHeader{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 头像上传成功
     * data : {"headImagePath":"http://39.107.224.233/fir6448872.png"}
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
                    "headImagePath='" + headImagePath + '\'' +
                    '}';
        }

        /**
         * headImagePath : http://39.107.224.233/fir6448872.png
         */

        private String headImagePath;

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }
    }
}
