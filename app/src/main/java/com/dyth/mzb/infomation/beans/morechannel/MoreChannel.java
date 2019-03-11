package com.dyth.mzb.infomation.beans.morechannel;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class MoreChannel {

    /**
     * code : 0
     * data : {"professionList":[{"professionId":"219323963b0411e8b64c00163e30445d","professionName":"人力资源"},{"professionId":"219791193b0411e8b64c00163e30445d","professionName":"其他"},{"professionId":"2196818a3b0411e8b64c00163e30445d","professionName":"媒体记者"},{"professionId":"2188e7113b0411e8b64c00163e30445d","professionName":"学生"},{"professionId":"218bfcb13b0411e8b64c00163e30445d","professionName":"安全"},{"professionId":"218cf9be3b0411e8b64c00163e30445d","professionName":"市场营销"},{"professionId":"218b061b3b0411e8b64c00163e30445d","professionName":"机务维修"},{"professionId":"219100d93b0411e8b64c00163e30445d","professionName":"机场运营"},{"professionId":"218e03fd3b0411e8b64c00163e30445d","professionName":"空中服务"},{"professionId":"218f08cd3b0411e8b64c00163e30445d","professionName":"空管"},{"professionId":"219006223b0411e8b64c00163e30445d","professionName":"航务运行"},{"professionId":"21957c9b3b0411e8b64c00163e30445d","professionName":"航材"},{"professionId":"21942b9e3b0411e8b64c00163e30445d","professionName":"航校培训"},{"professionId":"219214013b0411e8b64c00163e30445d","professionName":"货运物流"},{"professionId":"2189fdcf3b0411e8b64c00163e30445d","professionName":"飞行驾驶"}]}
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
        private List<ProfessionListBean> professionList;

        public List<ProfessionListBean> getProfessionList() {
            return professionList;
        }

        public void setProfessionList(List<ProfessionListBean> professionList) {
            this.professionList = professionList;
        }

        public static class ProfessionListBean {
            /**
             * professionId : 219323963b0411e8b64c00163e30445d
             * professionName : 人力资源
             */

            private String professionId;
            private String professionName;

            public String getProfessionId() {
                return professionId;
            }

            public void setProfessionId(String professionId) {
                this.professionId = professionId;
            }

            public String getProfessionName() {
                return professionName;
            }

            public void setProfessionName(String professionName) {
                this.professionName = professionName;
            }
        }
    }
}
