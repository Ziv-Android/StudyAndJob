package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

/**
 * 安装Apk程序代码
 * Created by Ziv on 2016/4/15.
 */
public class InstallApk {
    public void marketByName(Context context) {
        Uri uri = Uri.parse("market://search?q=应用名称");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public void marketByID(Context context) {
        // mobile.android.library为应用程序的package name
        Uri uri = Uri.parse("market://details?id=mobile.android.library");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public void install(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 指定apk文件的路径
        String filePath = Environment.getExternalStorageDirectory().getPath() + "/FileExplorer.apk";
        // 指定文件类型
        intent.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
        // 弹出安装界面
        context.startActivity(intent);
    }
}
