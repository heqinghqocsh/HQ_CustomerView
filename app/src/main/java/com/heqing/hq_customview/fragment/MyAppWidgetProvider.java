package com.heqing.hq_customview.fragment;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.widget.RemoteViews;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/19 0019.
 *
 * @description
 */
public class MyAppWidgetProvider extends AppWidgetProvider{

    public static final String TAG = "MyAppWidgetProvider";
    public static final String CLICK_ACTION = "com.heqing.hq_customview.CLICK";

    public MyAppWidgetProvider(){
        super();
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(CLICK_ACTION)){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap srcBitmap = BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.a);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    for(int i = 0;i < 37;i++){
                        float degree = (i * 10) / 360;
                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                                R.layout.app_widget);
                        remoteViews.setImageViewBitmap(R.id.widget_imageview,
                                rotateBitmap(context, srcBitmap, degree));
                        Intent intentClick = new Intent();
                        intentClick.setAction(CLICK_ACTION);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                                0,intentClick,0);
                        remoteViews.setOnClickPendingIntent(R.id.widget_imageview,
                                pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context
                                , MyAppWidgetProvider.class), remoteViews);
                        SystemClock.sleep(30);
                    }
                }
            }).start();
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int counter = appWidgetIds.length;
        for (int i = 0;i < counter;i++){
            int appWidgetId = appWidgetIds[i];
            onWidgetUpdate(context,appWidgetManager,appWidgetId);
        }
    }

    private void onWidgetUpdate(Context context,AppWidgetManager
            appWidgetManager,int appWidgetId){
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.app_widget);
        Intent intentClick = new Intent();
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                0,intentClick,0);
        remoteViews.setOnClickPendingIntent(R.id.widget_imageview,
                pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId,remoteViews);
    }

    private Bitmap rotateBitmap(Context context,Bitmap srcBitmap,float degree){
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmp = Bitmap.createBitmap(srcBitmap,0,0,srcBitmap.getWidth()
                ,srcBitmap.getHeight(),matrix,true);
        return tmp;
    }




}
