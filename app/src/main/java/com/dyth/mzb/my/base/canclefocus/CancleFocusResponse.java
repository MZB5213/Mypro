package com.dyth.mzb.my.base.canclefocus;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class CancleFocusResponse {


    /**
     * followIdList : ["1","2"]
     * userId : d56ea66e7ee741f498ca51242c8c6394
     */

    private String userId;
    private List<String> followIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFollowIdList() {
        return followIdList;
    }

    public void setFollowIdList(List<String> followIdList) {
        this.followIdList = followIdList;
    }
}
