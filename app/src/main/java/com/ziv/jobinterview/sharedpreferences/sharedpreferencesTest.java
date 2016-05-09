package com.ziv.jobinterview.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * SharedPreferences实现示例
 * Created by Ziv on 2016/4/25.
 */
public class SharedpreferencesTest extends AppCompatActivity {
    public String PREFERENCE_NAME = "ziv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        // 使用getXxx方法获取value，getXxx方法的第二个参数是value的默认值
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","ziv");
        editor.putBoolean("isHappy",true);
        editor.putFloat("money",15000f);
        editor.apply();

        // 获取数据直接
        sharedPreferences.getString("name","");
    }
}
