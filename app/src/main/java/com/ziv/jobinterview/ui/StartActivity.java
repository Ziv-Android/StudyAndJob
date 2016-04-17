package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.ziv.jobinterview.MainActivity;
import com.ziv.jobinterview.R;

/**
 * 启动后第一个Activity
 * Created by Ziv on 2016/4/16.
 */
public class StartActivity extends Activity {
    // 静态变量可以用来传递任意类型的数据
    public static String msg = "爱你";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 显示调用启动Activity
        Intent intent = new Intent(this, MainActivity.class);
        // 保存Integer类型的数据
        intent.putExtra("intent_integer", 300);
        // 在另一个Activity中获取数据的方法，0为默认值
        // getIntent().getExtras().getInt("intent_integer",0);
        startActivity(intent);

        // 隐式调用Activity
        // 指定Activity Action
        Intent intent1 = new Intent("mobile.android.MYACTION");
        // 调用可接收MYACTION动作的Activity，如果系统中有多个Activity，可接受Main动作
        // 则辉县市一个菜单供用户选择调用那个Activity

        // 使用剪切板保存数据
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        // 向剪切板中保存简单文本数据，setText方法已经被弃用,因此不建议使用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            clipboard.setText("九");
        }
        // 获取剪贴板中的文本数据
        // clipboard.getText();
        startActivity(intent1);
    }
}
