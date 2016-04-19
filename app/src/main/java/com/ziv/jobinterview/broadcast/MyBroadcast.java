package com.ziv.jobinterview.broadcast;

import android.content.Intent;

/**
 * 发送一条无序广播
 * Created by Ziv on 2016/4/18.
 */
public class MyBroadcast {
    // 通过intent参数可指定一个广播动作
    public void sendBroadcast(Intent intent){
        // 指定广播动作
        Intent broadcastIntent = new Intent("mobile.android.MYBROADCAST");
        // 添加category
        broadcastIntent.addCategory("mobile.android.mycategory");
        // 设置广播数据
        broadcastIntent.putExtra("name","broadcast_data");
        // 发送广播
        sendBroadcast(broadcastIntent);
    }
}
