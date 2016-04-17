package com.ziv.jobinterview.clipboard;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import com.ziv.jobinterview.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 通过剪贴板传递可序列化的Data数据
 */
public class ClipboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard);

        Intent intent = new Intent(this,GetMsgFromClipboardActivity.class);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        Data clipboardData = new Data();
        clipboardData.id = 666;
        clipboardData.name = "霞";
        // 将可序列化的clipboardData对象转成Base64格式的字符串
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String base64Str = "";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(clipboardData);
            // 使用Base64.encodeToString方法将byte[]数组转成Base64字符串
            base64Str = Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 向剪贴板写入数据 api11方法
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            clipboard.setText(base64Str);
        }
        startActivity(intent);
    }
}
