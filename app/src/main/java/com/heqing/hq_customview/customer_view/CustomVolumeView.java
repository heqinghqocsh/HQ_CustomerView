package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 何清 on 2016/6/4 0004.
 *
 * @description  自定义柱形图
 */
public class CustomVolumeView extends View{

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint;
    private int mRectCount;
    private int offset = 5;
    private double mRandom;
    private LinearGradient mLinearGradient;


    public CustomVolumeView(Context context) {
        super(context);
        initView();
    }

    public CustomVolumeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomVolumeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void  initView(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int)(mWidth * 0.6 / mRectCount);
        mLinearGradient = new LinearGradient(
                0,0,mRectWidth,mRectHeight,Color.RED,Color.GREEN, Shader.TileMode.CLAMP
        );
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0;i < mRectCount;i++){
            mRandom = Math.random();
            float currentHeight = (float)(mRectHeight * mRandom);
            canvas.drawRect((float)(mWidth * 0.4 / 2 + mRectWidth * i + offset)
                    ,currentHeight,(float)(mWidth * 0.4 / 2 + mRectWidth*(i+1)),mRectHeight,mPaint);
        }
//        postInvalidateDelayed(300);
    }
}
