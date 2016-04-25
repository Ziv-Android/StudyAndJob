package com.ziv.jobinterview.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ziv.jobinterview.R;

/**
 * 显示一个进度条对话框ProcessDialog
 * Created by Ziv on 2016/4/19.
 */
public class ProgressDialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("正在处理数据");
        progressDialog.setMessage("请稍后。。。");
        // 设置进度条对话框的风格
        // 圆形进度条风格样式 ProgressDialog.STYLE_SPINNER
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // 设置进度对话框的进度最大值
        progressDialog.setMax(100);
        progressDialog.setProgress(20);//设置进度条的当前进度
        progressDialog.setButton(1, "暂停", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 处理代码
            }
        });
        progressDialog.setButton(2, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 处理代码
            }
        });
        progressDialog.show();
    }
}
