package com.dyth.mzb.infomation.beans.comments;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class Comments  {


    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * objectId : d56ea66e7ee741f498ca51242c8c6394
     * objectType : 0
     * content : 测试
     */

    private String userId;
    private String objectId;
    private String objectType;
    private String content;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
