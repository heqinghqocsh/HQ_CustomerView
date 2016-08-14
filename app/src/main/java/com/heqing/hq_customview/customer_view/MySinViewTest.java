package com.heqing.hq_customview.customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 何清 on 2016/6/9 0009.
 *
 * @description
 */
public class MySinViewTest extends SurfaceView
        implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private boolean mIsDrawing;
    private int x = 0;
    private int y = 0;
    private Path mPath;
    private Path mPath2;
    private Path mPath3;
    private Path mPath4;
    private Paint mPaint;

    public MySinViewTest(Context context) {
        super(context);
        initView();
    }

    public MySinViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MySinViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        mHolder = getHolder();

        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        mPath = new Path();
        mPath2 = new Path();
        mPath3 = new Path();
        mPath4 = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        mPath.moveTo(0, 400);
        mPath2.moveTo(0,450);
        mPath3.moveTo(0,500);
        mPath4.moveTo(0,550);

        mCanvas = mHolder.lockCanvas();
        mCanvas.drawColor(Color.WHITE);
        mHolder.unlockCanvasAndPost(mCanvas);

        new Thread(this).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing){
            draw();
            x += 3;
            y = (int)(200*Math.sin(x*0.5*Math.PI/180)+400);
            mPath.lineTo(x,y);
            y += 50;
            mPath2.lineTo(x, y);
            y += 50;
            mPath3.lineTo(x, y);
            y += 50;
            mPath4.lineTo(x, y);
        }
    }

    private void draw(){
        try {
            mCanvas = mHolder.lockCanvas();
            mCanvas.drawPath(mPath,mPaint);
            mCanvas.drawPath(mPath2,mPaint);
            mCanvas.drawPath(mPath3,mPaint);
            mCanvas.drawPath(mPath4,mPaint);
        }catch (Exception e){
        }finally {
            if (mCanvas != null){
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
