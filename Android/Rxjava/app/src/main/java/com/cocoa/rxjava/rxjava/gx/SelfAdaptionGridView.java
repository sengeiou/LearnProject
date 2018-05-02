package com.cocoa.rxjava.rxjava.gx;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @Author RainDrop
 * @date 2015年11月12日
 * @time 下午7:11:55
 * GridView 自适应ScrollView,使GridView 正常显示高度
 */
public class SelfAdaptionGridView extends UnScrollGridView {

    public SelfAdaptionGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
