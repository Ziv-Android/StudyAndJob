package com.ziv.jobinterview.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ziv.jobinterview.R;

import java.lang.reflect.Field;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 改变对话框属性
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("在低端显示对话框").setPositiveButton("确定", null).create();
        Window window = alertDialog.getWindow();
        // 显示位置
        window.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        // 设置透明度
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // alpha属性值的范围从0.0f到1.0f
        layoutParams.alpha = 0.7f;
        window.setAttributes(layoutParams);
        alertDialog.show();

        // 自己控制Dialog的状态，修改mShowing = false后 dismiss方法失效
        try {
            Field field= alertDialog.getClass().getSuperclass().getDeclaredField("mShowing");
            field.setAccessible(true);
            // 将mShowing变量设为false，欺骗系统认为此对话框已经关闭
            field.set(alertDialog, false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
