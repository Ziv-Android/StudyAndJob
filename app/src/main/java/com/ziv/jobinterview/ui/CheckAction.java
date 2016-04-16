package com.ziv.jobinterview.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.List;

/**
 * 检查系统中是否安装包含Activity Action的apk文件
 * Created by Ziv on 2016/4/1.
 */
public class CheckAction {
    public void activity(Context context) {
        PackageManager packageManager = context.getPackageManager();
        // 指定要查找的Activity Action：com.android.phone.action.TOUCH_DIALER
        Intent intent = new Intent("com.android.phone.action.TOUCH_DIALER");
        // 在系统中查询执行的Activity Action
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent,
                PackageManager.GET_INTENT_FILTERS);
        // 如果没有返回任何结果，表明系统中没有指定的Activity Action
        if (resolveInfos.size() == 0) {
            Log.d("Action", "Activity不存在");
        }
    }

    public void broadcast(Context context){
        PackageManager packageManager = context.getPackageManager();
        // 指定要查找的Broadcast Action
        Intent intent = new Intent("com.android.MYBROADCAST");
        List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,
                PackageManager.GET_INTENT_FILTERS);
        // 没有结果则没找到
        if (resolveInfos.size() == 0){
            Log.d("Action", "BroadCast不存在");
        }
    }

    public void service(Service service, ServiceConnection connection){
        if (!service.bindService(new Intent(""), connection,Context.BIND_AUTO_CREATE)){
            Log.d("Action", "service不存在");
        }
    }

    public void contentProvide(Context context){
        Uri uri = Uri.parse("content://mobile.android.regioncontentprovider/cities");
        Cursor cursor = context.getContentResolver().query(uri,new String[]{"city_code as _id","city_name"},null,null,null);
        if (cursor == null) {
            Log.d("Action", "contentProvide不存在");
        }
    }


}
