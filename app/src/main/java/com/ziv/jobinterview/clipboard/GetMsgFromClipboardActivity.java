package com.ziv.jobinterview.clipboard;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.ziv.jobinterview.R;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 接收通过剪贴板传递过来的Data数据
 */
public class GetMsgFromClipboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_msg_from_clipboard);

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        // 从剪贴板中获得Base64编码格式的字符串 api 11
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            String base64Str = clipboard.getText().toString();
            byte[] buffer = Base64.decode(base64Str, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            try {
                ObjectInputStream ois = new ObjectInputStream(bais);
                // 将byte[]数据还原成Data对象中的字段值
                Data data = (Data) ois.readObject();
                Log.e("ziv", "GetMsgFromClipboardActivity"+ " Data" +
                        " ID = " + data.id + " Name = " + data.name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
