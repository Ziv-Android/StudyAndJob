package com.ziv.jobinterview.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 自定义service
 * Created by Ziv on 2016/4/21.
 */
public class MyService extends Service{
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
