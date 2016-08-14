package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.zip.InflaterInputStream;

/**
 * Created by 何清 on 2016/6/6 0006.
 *
 * @description
 */
public class DragView1 extends View{

    private int lastX;
    private int lastY;

    public DragView1(Context context) {
        super(context);
        initView();
    }

    public DragView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setBackgroundColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                Log.d("tag","ACTION_DOWN"+lastX+"---"+lastY);
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                Log.d("tag","ACTION_MOVE"+lastX+"---"+lastY);
                layout(getLeft() + offsetX,
                        getTop() + offsetY, getRight() + offsetX, getBottom()+offsetY);
                break;
        }
        return true;
    }
}
