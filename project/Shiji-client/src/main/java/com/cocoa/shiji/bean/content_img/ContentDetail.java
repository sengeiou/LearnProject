package com.cocoa.shiji.bean.content_img;

public class ContentDetail {

    private ContentDetailType type;
    private int width;
    private int height;
    private String value;


    public ContentDetailType getType() {
        return type;
    }

    public void setType(ContentDetailType type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
