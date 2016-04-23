package com.ziv.jobinterview.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ziv.jobinterview.R;

/**
 * 创建一条Notification通知信息
 * Created by Ziv on 2016/4/20.
 */
public class MyNotification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1 通过getSystemService方法获得一个NotificationManager对象
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // 2 创建一个Notification对象。每一个Notification对应一个Notification对象，在这一步需要设置在屏幕上方状态栏的通知消息、通知消息前方的图像资源ID和发出通过的时间，一般为当前时间
        Notification notification = new Notification(R.mipmap.ic_launcher, "新消息", System.currentTimeMillis());
        // 3 由于Notification可以与应用程序脱离，也就是说，即使应用程序关闭，Notification任然会显示在状态栏中。当应用程序再次启动后，又可以重新控制这些Notification，如清楚和替换他们。
        // 因此，需要创建一个PendingIntent对象。该对象由Android系统负责维护，因此，在应用程序关闭后，该对象任然不会被释放
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, getIntent(), 0);
        // 4 使用Notification类的setLatestEventInfo方法设置Notification的详细信息
        // TODO: 2016/4/21 setLatestEventInfo方法无法调用，原因未知，待解决
        // notification.setLatestEventInfo(this,"天气预报","晴转多云",contentIntent);
        // 5 使用NotificationManager类的notify方法显示Notification消息。在这一步需要制定标识Notification的唯一ID。这个ID必须相对于同一个NotificationManager对象是唯一的，否则就会覆盖相同ID的Notification
        notificationManager.notify(R.mipmap.ic_launcher, notification);
    }
}
