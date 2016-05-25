package cv.cocoa.com.customerlayout;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: cv.cocoa.com.customerlayout.DragLayout.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-03-30 15:09
 */
public class DragLayout extends ViewGroup {

    private List<View> mDragViewList;
    private ViewDragHelper  mViewDragHelper;

    public DragLayout(Context context) {
        super(context);init();

    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        mViewDragHelper = ViewDragHelper.create(this,10f,new DragCallback());

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if(action==MotionEvent.ACTION_CANCEL || MotionEvent.ACTION_UP==action){
            mViewDragHelper.cancel();
            return  false;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDragViewList = new ArrayList<>();
        for(int  i= 0;i<getChildCount();i++){
            mDragViewList.add(getChildAt(i));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        for(int  i= 0;i<mDragViewList.size();i++){
            mDragViewList.get(i).layout(l, t, 100, 100);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(
                resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
                resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }


    class DragCallback extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            Log.e("----pointerId","----------------pointerId--------"+pointerId+"---------");
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            Log.d("DragLayout", "clampViewPositionHorizontal " + left + "," + dx);
            final int leftBound = getPaddingLeft();
            final int rightBound = getWidth() - child.getWidth();
            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
            return newLeft;
        }
    }


}
