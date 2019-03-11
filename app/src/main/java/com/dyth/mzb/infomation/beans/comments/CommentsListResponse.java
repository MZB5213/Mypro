package com.dyth.mzb.infomation.beans.comments;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsListResponse {


    /**
     * objectId : d56ea66e7ee741f498ca51242c8c6394
     * objectType : 0
     * cursor : 0
     */

    private String objectId;
    private String objectType;
    private int cursor;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
