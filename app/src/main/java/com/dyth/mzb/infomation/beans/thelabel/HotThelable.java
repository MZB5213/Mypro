package com.dyth.mzb.infomation.beans.thelabel;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class HotThelable {


    @Override
    public String toString() {
        return "HotThelable{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : [{"id":"e49222bf3b0611e8b64c00163e30445d","tag":"通航展论"}]
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
                    "id='" + id + '\'' +
                    ", tag='" + tag + '\'' +
                    '}';
        }

        /**
         * id : e49222bf3b0611e8b64c00163e30445d
         * tag : 通航展论
         */


        private String id;
        private String tag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
