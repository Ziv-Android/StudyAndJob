package com.ziv.jobinterview.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ziv.jobinterview.MainActivity;

/**
 * 监听开机广播，开机启动Activity
 * Created by Ziv on 2016/4/18.
 */
public class StartupReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainIntent = new Intent(context, MainActivity.class);
        // 在广播接收器中显示Activity，必须要设置FLAG_ACTIVITY_NEW_TASK标志
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
    }
}
