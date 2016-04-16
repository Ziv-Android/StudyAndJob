package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.os.Bundle;

import com.ziv.jobinterview.R;

/**
 * 启动后第一个Activity
 * Created by Ziv on 2016/4/16.
 */
public class StartActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
