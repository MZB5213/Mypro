package com.dyth.mzb.infomation.beans.Collection;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class Collection {

    @Override
    public String toString() {
        return "Collection{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * code : 0
     * data : {"cursor":"1543397990","favouritNewsList":[{"favouritId":"3895182c908447b2a5953a665561cd6b","newsId":null,"title":null},{"favouritId":"17e4a46788a741b9a641b958b71da7ac","newsId":"272c8a46acec4a6f942145396fc83ca7","title":"民航局适航司关于发布改进通用航空适航审定政策实施细则的通知"},{"favouritId":"8deb84b23e034f7e9d255ecbdd5376e6","newsId":"4780fbbff25c49d09cd8ef9261a7e38d","title":"飞机洗澡可不是指洗飞机，关于公务机适航审定那些事儿"},{"favouritId":"5457d3fca4cd40488a102541a7035878","newsId":"ad30af17a2ad44fca00a2d3f7e16c004","title":"重庆开州召开通用机场选址报告评审会 确定选址大德镇仁和村"},{"favouritId":"3edcbdf8e7bd4bd18bda3de3d10cea50","newsId":"80edd8bb70d94133ac8cab321c1c7a35","title":"关于航空工业对外开放有关政策解读"},{"favouritId":"6633919b67704ee4ac619477e3ce7f9e","newsId":"dd5cbfef9a204af38e04ef97a58e0c5a","title":"不看不知道，一看吓一跳的2018珠海航展又来了！！"},{"favouritId":"ee0d696a116d40f9985d4f1c297e1cf3","newsId":"259ea33045964249a5f0fd0792ac2af6","title":"SureFly混合动力直升机首飞，科技改变出行"},{"favouritId":"74cfecc4f4dd421ea03506caa7acb149","newsId":"d52b14aa65df4833893e512f9bb8a139","title":"雄安航空要来了！南航拟出资100亿元设立子公司"},{"favouritId":"477d1f2a632d43bd9634fe3992248e00","newsId":"292eb7835fa84f3eb44c12c28e021422","title":"常州中联飞机制造携自主制造两代轻型直升机亮相2018郑州航展"},{"favouritId":"9e9b400f29c5475e80695e662c0b4afa","newsId":"6b9869613a714098a868a1199db92dec","title":"如何更规划的使用无人机？"}]}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "cursor='" + cursor + '\'' +
                    ", favouritNewsList=" + favouritNewsList +
                    '}';
        }

        /**
         * cursor : 1543397990
         * favouritNewsList : [{"favouritId":"3895182c908447b2a5953a665561cd6b","newsId":null,"title":null},{"favouritId":"17e4a46788a741b9a641b958b71da7ac","newsId":"272c8a46acec4a6f942145396fc83ca7","title":"民航局适航司关于发布改进通用航空适航审定政策实施细则的通知"},{"favouritId":"8deb84b23e034f7e9d255ecbdd5376e6","newsId":"4780fbbff25c49d09cd8ef9261a7e38d","title":"飞机洗澡可不是指洗飞机，关于公务机适航审定那些事儿"},{"favouritId":"5457d3fca4cd40488a102541a7035878","newsId":"ad30af17a2ad44fca00a2d3f7e16c004","title":"重庆开州召开通用机场选址报告评审会 确定选址大德镇仁和村"},{"favouritId":"3edcbdf8e7bd4bd18bda3de3d10cea50","newsId":"80edd8bb70d94133ac8cab321c1c7a35","title":"关于航空工业对外开放有关政策解读"},{"favouritId":"6633919b67704ee4ac619477e3ce7f9e","newsId":"dd5cbfef9a204af38e04ef97a58e0c5a","title":"不看不知道，一看吓一跳的2018珠海航展又来了！！"},{"favouritId":"ee0d696a116d40f9985d4f1c297e1cf3","newsId":"259ea33045964249a5f0fd0792ac2af6","title":"SureFly混合动力直升机首飞，科技改变出行"},{"favouritId":"74cfecc4f4dd421ea03506caa7acb149","newsId":"d52b14aa65df4833893e512f9bb8a139","title":"雄安航空要来了！南航拟出资100亿元设立子公司"},{"favouritId":"477d1f2a632d43bd9634fe3992248e00","newsId":"292eb7835fa84f3eb44c12c28e021422","title":"常州中联飞机制造携自主制造两代轻型直升机亮相2018郑州航展"},{"favouritId":"9e9b400f29c5475e80695e662c0b4afa","newsId":"6b9869613a714098a868a1199db92dec","title":"如何更规划的使用无人机？"}]
         */



        private String cursor;
        private List<FavouritNewsListBean> favouritNewsList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<FavouritNewsListBean> getFavouritNewsList() {
            return favouritNewsList;
        }

        public void setFavouritNewsList(List<FavouritNewsListBean> favouritNewsList) {
            this.favouritNewsList = favouritNewsList;
        }

        public static class FavouritNewsListBean {
            /**
             * favouritId : 3895182c908447b2a5953a665561cd6b
             * newsId : null
             * title : null
             */

            private String favouritId;
            private Object newsId;
            private Object title;

            public Boolean getIschead() {
                return ischead;
            }

            public void setIschead(Boolean ischead) {
                this.ischead = ischead;
            }

            private Boolean ischead = true;


            public String getFavouritId() {
                return favouritId;
            }

            public void setFavouritId(String favouritId) {
                this.favouritId = favouritId;
            }

            public Object getNewsId() {
                return newsId;
            }

            public void setNewsId(Object newsId) {
                this.newsId = newsId;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }
        }
    }
}
