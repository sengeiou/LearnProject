package com.cocoa.rxjava.rxjava.gx;

/**
 * Created by junshen on 2018/4/11.
 */

public class BrandItem {
    private String imgUrl;
    private String id;
    private String text;
    private boolean clickTag = false;
    private static int prePosition = -1;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isClickTag() {
        return clickTag;
    }

    public void setClickTag(boolean clickTag) {
        this.clickTag = clickTag;
    }

    public static int getPrePosition() {
        return prePosition;
    }

    public static void setPrePosition(int prePosition) {
        BrandItem.prePosition = prePosition;
    }
}
