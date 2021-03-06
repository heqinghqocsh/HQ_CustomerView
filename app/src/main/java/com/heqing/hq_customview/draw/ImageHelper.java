package com.heqing.hq_customview.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by 何清 on 2016/6/7 0007.
 *
 * @description
 */
public class ImageHelper {

    public static Bitmap handleImageEffect(Bitmap bm,float hue,float saturation,float lum){
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);

        Paint paint = new Paint();
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);


        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        /*ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.setRotate(0,hue);
        imageMatrix.setRotate(1, hue);
        imageMatrix.setRotate(2, hue);
        imageMatrix.setSaturation(saturation);
        imageMatrix.setScale(lum, lum, lum,1);*/

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm,0,0,paint);
        return bmp;
    }

}
