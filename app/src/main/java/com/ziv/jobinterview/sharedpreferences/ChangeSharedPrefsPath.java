package com.ziv.jobinterview.sharedpreferences;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 修改SharedPreferences文件保存路径到SD卡
 * Created by Ziv on 2016/4/26.
 */
public class ChangeSharedPrefsPath extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // 获取ContextWrapper对象中的mBase变量，该变量保存了ContextImpl对象
            Field field = ContextWrapper.class.getDeclaredField("mBase");
            field.setAccessible(true);
            // 获取mBase变量的值
            Object obj = field.get(this);
            // 获取ContextImpl.mPreferencesDir变量，该变量保存了数据文件的保存路径
            field = obj.getClass().getDeclaredField("mPreferencesDir");
            field.setAccessible(true);
            // 创建自定义的路径
            File file = new File(Environment.getExternalStorageDirectory().getPath());
            // 修改mPreferencesDir变量的值
            field.set(obj,file);

            // 路径修改完成，创建SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("config", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name","ziv");
            // editor.commit();
            editor.apply();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
