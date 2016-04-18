package com.ziv.jobinterview.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * 获取短信内容
 * Created by Ziv on 2016/4/18.
 */
public class ShortMessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            // 获得收到的短信数据
            Object[] objArray = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[objArray.length];
            // 处理所有收到的短信
            for (int i = 0; i < objArray.length; i++) {
                // 将每条短信数据转换成SmsMessage对象
                messages[i] = SmsMessage.createFromPdu((byte[]) objArray[i]);
                // 获得发送短信的手机号和短信内容
                String s = "手机号: " + messages[i].getOriginatingAddress() + "\n";
                s += "短信内容" + messages[i].getDisplayMessageBody();
                Log.e("ziv",s);
            }
        }
    }
    // 完成后记得在AndroidManifest.xml清单文件中定义ShortMessageReceiver，并添加Action
    /**
     *
     */
}
