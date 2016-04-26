package com.ziv.jobinterview.sharedpreferences;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 通过文件流的形式读取SharedPreferences文件
 * Created by Ziv on 2016/4/26.
 */
public class StreamSharedPrefsFile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String path = Environment.getDataDirectory()
                .getAbsolutePath() + "/data" +getPackageName()+"/shared_prefs/ziv.xml";
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            // 显示SharedPreferences文件中的内容
            Log.e("ziv","StreamSharedPrefsFile "+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
