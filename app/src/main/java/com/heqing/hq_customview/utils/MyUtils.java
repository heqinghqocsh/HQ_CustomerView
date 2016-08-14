package com.heqing.hq_customview.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.RotateAnimation;

/**
 * Created by 何清 on 2016/5/28 0028.
 *
 * @description
 */
public class MyUtils {

    public static void startAnimOut(View view,int delay){
        RotateAnimation animation = new RotateAnimation(
                0,180,view.getWidth() / 2,view.getHeight()
        );
        animation.setDuration(500);
        animation.setFillAfter(true);//动画执行完成后保持最后的状态
        animation.setStartOffset(delay);
        view.startAnimation(animation);
    }

    public static void startAnimIn(View view){
        RotateAnimation animation = new RotateAnimation(
                180,360,view.getWidth() / 2,view.getHeight()
        );
        animation.setDuration(500);
        animation.setFillAfter(true);//动画执行完成后保持最后的状态
        view.startAnimation(animation);
    }

    public static DisplayMetrics getScreenMetrics(Context context){
        return context.getResources().getDisplayMetrics();
    }

    public static int dp2px(Context context,int dp){
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,
                context.getResources().getDisplayMetrics()));
    }

}
