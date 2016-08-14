package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 何清 on 2016/6/4 0004.
 *
 * @description 圆形进度
 */
public class CircleProgressView extends View {

    private int mMeasureHeight;
    private int mMeasureWidth;

    private Paint mCirclePaint;
    private float mCircleXY;
    private float mRadius;

    private Paint mArcPaint;
    private RectF mArcRectF;
    private float mSweepAngel;
    private float mSweepValue = 66;

    private Paint mTextPaint;
    private String mShowText;
    private float mShowTextSize;


    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeight);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        //回执弧线
        canvas.drawArc(mArcRectF, 270, mSweepAngel, false, mArcPaint);
        //回执文字
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY
                , mCircleXY + (mShowTextSize / 4), mTextPaint);
    }

    private void initView() {
        float length = 0;
        if (mMeasureHeight >= mMeasureWidth) {
            length = mMeasureWidth;
        } else {
            length = mMeasureHeight;
        }

        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcRectF = new RectF((float) (length * 0.1)
                , (float) (length * 0.1)
                , (float) (length * 0.9)
                , (float) (length * 0.9));
        mSweepAngel = mSweepValue / 100f * 360f;
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mShowText = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

    public String setShowText() {
        this.invalidate();
        return "75%";
    }

    public float setShowTextSize() {
        this.invalidate();
        return 40;
    }

    public void forceInvalidate(){
        this.invalidate();
    }

    public void setSweepValue(float sweepValue){
        if (sweepValue != 0){
            mSweepValue = sweepValue;
        }else {
            mSweepValue = 25;
        }
        this.invalidate();
    }

}
