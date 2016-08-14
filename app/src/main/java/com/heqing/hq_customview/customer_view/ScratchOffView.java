package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/9 0009.
 *
 * @description  刮刮乐
 */
public class ScratchOffView extends View{

    private Bitmap mbgBitmap,mfgBitmap;
    private Paint mPaint;
    private Canvas mCanvas;
    private Path mPath;

    public ScratchOffView(Context context) {
        super(context);
        init();
    }

    public ScratchOffView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAlpha(0);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();
        mbgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        mfgBitmap = Bitmap.createBitmap(mbgBitmap.getWidth(), mbgBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mfgBitmap);
        mCanvas.drawColor(Color.GRAY);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(),event.getY());
                break;
        }
        mCanvas.drawPath(mPath,mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mbgBitmap,0,0,null);
        canvas.drawBitmap(mfgBitmap,0,0,null);
    }
}
