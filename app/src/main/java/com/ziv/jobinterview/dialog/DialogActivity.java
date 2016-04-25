package com.ziv.jobinterview.dialog;

import android.app.Activity;
import android.os.Bundle;

import com.ziv.jobinterview.R;

import java.util.Arrays;

/**
 * 使用Activity theme主题实现Dialog效果
 * Created by Ziv on 2016/4/17.
 */
public class DialogActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        setTheme(R.style.myDialogTheme);
    }
}
