package com.ziv.jobinterview.broadcast.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射挂断电话
 * Created by Ziv on 2016/4/18.
 */
public class InCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 获得电话关系服务，以便获得电话的状态
        TelephonyManager telephonyManager = (TelephonyManager) context.
                getSystemService(Service.TELEPHONY_SERVICE);
        // 根据不同的来电状态进行处理
        switch (telephonyManager.getCallState()) {
            case TelephonyManager.CALL_STATE_RINGING:       // 响铃
                // 获得来电号码
                String incomingNumber = intent.getStringExtra("incoming_number");
                // 如果来电号码是15211111111，则挂断电话
                if ("15211111111".equals(incomingNumber)) {
                    try {
                        MyEndCall(telephonyManager);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            case TelephonyManager.CALL_STATE_OFFHOOK:       // 接听
                Log.e("ziv","phone off hook");
                break;
            case TelephonyManager.CALL_STATE_IDLE:          // 挂断
                break;
        }
    }

    private void MyEndCall(TelephonyManager telephonyManager) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<TelephonyManager> telephonyManagerClass = TelephonyManager.class;
        // 通过Java反射技术获取getITelephony方法对应的Method对象
        Method telephonyMethod = telephonyManagerClass
                .getDeclaredMethod("getITelephony", (Class[]) null);
        // 允许访问getITelephony方法
        telephonyMethod.setAccessible(true);
        // 调用getITelephony方法获取IThelephony对象
        Object obj = telephonyMethod.invoke(telephonyManager, (Object[]) null);
        // 获取与endCall方法对应的Method对象
        Method endCallMethod = obj.getClass().getMethod("endCall", null);
        // 允许访问endCall方法
        endCallMethod.setAccessible(true);
        // 调用endCall方法
        endCallMethod.invoke(obj, null);
    }
}
