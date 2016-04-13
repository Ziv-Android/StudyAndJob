package com.ziv.jobinterview;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 功能包括
 * 1 多dex分包，65535方法数超限
 * 2 LeakCanary内存泄漏监测
 *
 * Created by Ziv on 2016/3/23.
 */
public class MyApplication extends MultiDexApplication{
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context){
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
