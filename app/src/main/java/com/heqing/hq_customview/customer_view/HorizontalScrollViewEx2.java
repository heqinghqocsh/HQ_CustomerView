package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by 何清 on 2016/6/17 0017.
 *
 * @description 自定义可以水平华东的view，类似ViewPager
 */
public class HorizontalScrollViewEx2 extends ViewGroup{
    private static final String TAG = "HorizontalScrollViewEx2";

    private int mChildrenSize;
    private int mChildWidth;
    private int mChildIndex;
    //分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    //分别记录上次滑动的坐标(onInterceptTouchEvent)
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;

    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    public HorizontalScrollViewEx2(Context context) {
        super(context);
        init();
    }

    public HorizontalScrollViewEx2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalScrollViewEx2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mScroller = new Scroller(getContext());
        mVelocityTracker = VelocityTracker.obtain();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int)ev.getX();
        int y = (int)ev.getY();
        int action = ev.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            mLastX = x;
            mLastY = y;
            if (!mScroller.isFinished()){
                mScroller.abortAnimation();
                return true;
            }
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Log.d(TAG, "move, X:" + x + " Y:" + y);
                Log.d(TAG, "move, mLastX:" + mLastX + " mLastY:" + mLastY);
                Log.d(TAG, "move, deltaX:" + deltaX + " deltaY:" + deltaY);
                scrollBy(-deltaX,0);
                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                int scrollToChildIndex = scrollX / mChildWidth;
                mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity) >= 50){
                    mChildIndex = xVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
                }else{
                    mChildIndex = (scrollX + mChildWidth / 2) / mChildWidth;
                }
                mChildIndex = Math.max(0,Math.min(mChildIndex,mChildrenSize - 1));
                int dx = mChildIndex * mChildWidth - scrollX;
                smoothScrollBy(dx,0);
                mVelocityTracker.clear();
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = 0;
        int measureHeight = 0;
        final int childCount = getChildCount();
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if (childCount == 0){
            setMeasuredDimension(0,0);
        }else if(heightSpecMode == MeasureSpec.AT_MOST){
            final View childView = getChildAt(0);
            measureHeight = childView.getMeasuredHeight();
            setMeasuredDimension(widthSpaceSize,childView.getMeasuredHeight());
        }else if(widthSpecMode == MeasureSpec.AT_MOST){
            final View childView = getChildAt(0);
            measureWidth = childView.getMeasuredWidth() * childCount;
            setMeasuredDimension(measureWidth,heightSpaceSize);
        }else{
            final View childView = getChildAt(0);
            measureWidth = childView.getMeasuredWidth() * childCount;
            measureHeight = childView.getMeasuredHeight();
            setMeasuredDimension(measureWidth,measureHeight);
        }



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;
        final int childCount = getChildCount();
        mChildrenSize = childCount;
        for(int i = 0;i < childCount;i++){
            final View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE){
                final int childWidth = childView.getMeasuredWidth();
                mChildWidth = childWidth;
                childView.layout(childLeft,0,childLeft+childWidth,childView.getMeasuredHeight());
                childLeft += childWidth;
            }
        }
    }

    private void smoothScrollBy(int dx,int dy){
        mScroller.startScroll(getScrollX(),0,dx,0,500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }
}
