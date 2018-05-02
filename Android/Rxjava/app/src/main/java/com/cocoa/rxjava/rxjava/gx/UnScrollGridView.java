package com.cocoa.rxjava.rxjava.gx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * @Author RainDrop
 * @date 2015年12月3日
 * @time 上午10:15:19
 * 不滚动的GridView
 */
public class UnScrollGridView extends GridView {

    public UnScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

}
