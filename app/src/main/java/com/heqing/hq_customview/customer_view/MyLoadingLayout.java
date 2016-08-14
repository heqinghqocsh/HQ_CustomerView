package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HeQing on 2016/8/14 0014.
 * 自定义的加载布局
 */
public class MyLoadingLayout extends View{

    private float scale;//手机像素密度
    private float height;//控件高度
    private float width;//控件宽度

    public MyLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    Paint mPaint;
    private void init(Context context){
        scale = context.getResources().getDisplayMetrics().density;
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(circle_r);
        mPaint.setStyle(Paint.Style.FILL);
    }

    private float circle_r;//圆半径
    private float circle_space;//圆间距
    private float circle_r1;//圆1半径
    private float circle_r2;//圆2半径
    private float circle_r3;//圆3半径

    private boolean circle_r1_state = true;//圆1状态，true减小false增大
    private boolean circle_r2_state = true;//圆2状态，true减小false增大
    private boolean circle_r3_state = true;//圆3状态，true减小false增大

    /**
     * 以下四个量频繁用到，抽取出来可以避免频繁做相同的计算，可以提高性能
     */
    private float mPointY;//Y轴原点相同
    private float mCenterPointX;//中间那个圆的X轴原点
    private float half_circle_r;//圆半径的一半
    private float offset;//第一个，第三个相对于中间那个的位移

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        height = this.getHeight();
        width = this.getWidth();
        circle_r = width / 3 / 3 / 2;
        float temp = circle_r / 6;
        circle_r1 = circle_r;
        circle_r2 = circle_r - temp;
        circle_r3 = circle_r - temp*2;
        circle_space = scale;

        mPointY = height / 2;
        mCenterPointX = width / 2;
        half_circle_r = circle_r / 2;
        offset = 2*circle_r + circle_space;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画第一个圆
        canvas.drawCircle(mCenterPointX - offset,mPointY,circle_r1,mPaint);
        if (circle_r1_state){
            circle_r1 -= 0.5f;
            if (circle_r1 <= half_circle_r){
                circle_r1_state = false;
            }
        }else{
            circle_r1 += 0.5f;
            if (circle_r1 >= circle_r){
                circle_r1_state = true;
            }
        }

        //画第二个圆
        canvas.drawCircle(mCenterPointX,mPointY,circle_r2,mPaint);
        if (circle_r2_state){
            circle_r2 -= 0.5f;
            if (circle_r2 <= half_circle_r){
                circle_r2_state = false;
            }
        }else{
            circle_r2 += 0.5f;
            if (circle_r2 >= circle_r){
                circle_r2_state = true;
            }
        }

        //画第二个圆
        canvas.drawCircle(mCenterPointX + offset,mPointY,circle_r3,mPaint);
        if (circle_r3_state){
            circle_r3 -= 0.5f;
            if (circle_r3 <= half_circle_r){
                circle_r3_state = false;
            }
        }else{
            circle_r3 += 0.5f;
            if (circle_r3 >= circle_r){
                circle_r3_state = true;
            }
        }

        postInvalidate();
    }
}
