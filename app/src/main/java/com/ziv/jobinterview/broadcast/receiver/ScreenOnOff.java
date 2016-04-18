package com.ziv.jobinterview.broadcast.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 通过广播拦截手机屏幕的休眠与唤醒动作，只能动态注册
 * Created by Ziv on 2016/4/18.
 */
public class ScreenOnOff extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        ScreenOnOffReceiver screenOnOffReceiver = new ScreenOnOffReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenOnOffReceiver,intentFilter);
        return null;
    }

    class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case Intent.ACTION_SCREEN_ON:

                    break;
                case Intent.ACTION_SCREEN_OFF:

                    break;
            }
        }
    }
}
