package com.dyth.mzb.infomation.beans.content;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class MessageResponse {


    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * channelId : b93dcb5d3b0211e8b64c00163e30445d
     * cursor : 0
     */

    private String userId;
    private String channelId;
    private String cursor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
