package com.heqing.hq_customview.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RemoteViews;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.activity.MainActivity;

/**
 * Created by 何清 on 2016/6/19 0019.
 *
 * @description
 */
public class NotificationTest extends Fragment implements View.OnClickListener{

    private Button notification_1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notification_test_layout,null);
        notification_1 = (Button)rootView.findViewById(R.id.notification_1);
        notification_1.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notification_1:
                Notification notification;

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());

                RemoteViews remoteViews = new RemoteViews(getActivity().getPackageName(),
                        R.layout.app_widget);
                remoteViews.setImageViewResource(R.id.widget_imageview,R.mipmap.a);
                Intent intent = new Intent(getActivity(),MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(),
                        0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Bitmap bitmap = BitmapFactory
                        .decodeResource(getContext().getResources(),R.mipmap.b);
                notification = builder.setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bitmap)
                        .setContent(remoteViews)
                        .setContentIntent(pendingIntent)
                        .setContentTitle("你好").build();

                NotificationManager notificationManager = (NotificationManager)getActivity()
                        .getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,notification);
                break;
        }
    }
}
