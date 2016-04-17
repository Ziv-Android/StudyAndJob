package com.ziv.jobinterview.callsystemactivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * 调用系统自带的界面，完成相应功能
 * Created by Ziv on 2016/4/17.
 */
public class SystemActivity {
    private SystemActivity activity = null;
    private Context context;

    private SystemActivity() {
    }

    public SystemActivity getInstance(Context context) {
        if (activity == null) {
            activity = new SystemActivity();
        }
        this.context = context;
        return activity;
    }

    /**
     * 直接拨号
     */
    public void callPhone() {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:15211111111"));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // 没有请求到打电话权限，返回
            return;
        } else {
            context.startActivity(callIntent);
        }
    }

    /**
     * 将电话号码传入拨号界面
     */
    public void dialPhone() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15211111111"));
        context.startActivity(dialIntent);
    }

    /**
     * 调用拨号页面
     */
    public void touchDialerPhone() {
        Intent touchDialerIntent = new Intent("com.android.phone.action.TOUCH_DIALER");
        context.startActivity(touchDialerIntent);
    }

    /**
     * 调用系统浏览器
     */
    public void webWindow() {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        context.startActivity(webIntent);
    }

    /**
     * 调用系统程序查看联系人
     */
    public void contactList() {
        Intent contactListIntent = new Intent("com.android.contacts.action.LIST_CONTACTS");
        context.startActivity(contactListIntent);
    }

    /**
     * 调用系统设置界面
     */
    public void setting() {
        Intent settingIntent = new Intent("android.settings.SETTINGS");
        context.startActivity(settingIntent);
    }

    /**
     * 显示WiFi设置界面
     */
    public void wifiSetting() {
        Intent wifiSettingIntent = new Intent("android.settings.WIFI_SETTINGS");
        context.startActivity(wifiSettingIntent);
    }
}
