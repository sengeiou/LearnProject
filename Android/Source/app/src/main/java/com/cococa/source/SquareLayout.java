package com.cococa.source;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName:
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/7/21 17:2 */
public class SquareLayout extends LinearLayout {

    public SquareLayout(Context context, AttributeSet attrs,
                        int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLayout(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));

        int childWidthSize = getMeasuredWidth();
        // 高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
