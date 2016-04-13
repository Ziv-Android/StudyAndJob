package com.ziv.jobinterview.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ziv.jobinterview.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 在一个activity中注册EventBus事件，和Android的广播机制类似
 * 需要首先注册广播，然后需要编写内部类，实现接收广播，然后操作UI
 */
public class BusTerminalStationActivity extends AppCompatActivity {
    // 显示消息的View
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_terminal_station);
        mMessageEditText = (EditText) findViewById(R.id.messageET);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.e("postEvent", Thread.currentThread().getName());
//                        String message = mMessageET.getText().toString();
//                        if(TextUtils.isEmpty(message)) {
//                            message = "defaule message";
//                        }
//                        EventBus.getDefault().post(new MessageEvent(message));
//                    }
//                }).start();
                Log.e("postEvent", Thread.currentThread().getName());
                String message = mMessageEditText.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    message = "defaule message";
                }
                EventBus.getDefault().post(new MessageEvent(message));
            }
        });

        findViewById(R.id.send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mMessageEditText.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    message = "defaule message";
                }
                Intent intent = new Intent();
                intent.setAction("message_broadcast");
                intent.putExtra("message", message);
                sendBroadcast(intent);
            }
        });
    }
}
