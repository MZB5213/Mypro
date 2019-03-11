package com.dyth.mzb.my.base.feedback;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class MyFeedBack {

    @Override
    public String toString() {
        return "MyFeedBack{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * message : 成功
     * data : [{"answer":"广告合沟通。","id":"5e6bc8cb14da40598ea4fb0f0a8b0285","question":"如何翻找之前看过的文章？"}]
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
                    "answer='" + answer + '\'' +
                    ", id='" + id + '\'' +
                    ", question='" + question + '\'' +
                    '}';
        }

        /**
         * answer : 广告合沟通。
         * id : 5e6bc8cb14da40598ea4fb0f0a8b0285
         * question : 如何翻找之前看过的文章？
         */



        private String answer;
        private String id;
        private String question;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }
    }
}
