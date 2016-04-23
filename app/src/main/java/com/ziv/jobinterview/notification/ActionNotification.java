package com.ziv.jobinterview.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ziv.jobinterview.MainActivity;
import com.ziv.jobinterview.R;
import com.ziv.jobinterview.service.MyService;

/**
 * 点击Notification触发的动作
 * 动作的改变仅依靠PendingIntent对象
 * 清除Notification使用
 * Created by Ziv on 2016/4/21.
 */
public class ActionNotification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 点击Notification启动Activity
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.ic_launcher, "新消息", System.currentTimeMillis());
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        //notification.setLatestEventInfo(this,"Title","Content",contentIntent);
        notificationManager.notify();

        // 点击Notification发出一条广播
        Intent intentBroad = new Intent("MyBroadcast");
        PendingIntent pendingBroadcastIntent = PendingIntent.getBroadcast(this, 1, intentBroad, PendingIntent.FLAG_UPDATE_CURRENT);

        // 点击Notification启动Service
        Intent intentService = new Intent(this, MyService.class);
        PendingIntent pendingServiceIntent = PendingIntent.getService(this, 2, intentService, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
