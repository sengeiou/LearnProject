package com.cocoa.rxjava.rxjava.gx;

/**
 * Created by junshen on 2018/4/11.
 */

public class CommSelectItem {
    private String text;
    private boolean clickTag = false;
    private static int prePosition = -1;


    public CommSelectItem(String text) {
        this.text = text;
    }

    public boolean isClickTag() {
        return clickTag;
    }

    public void setClickTag(boolean clickTag) {
        this.clickTag = clickTag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
