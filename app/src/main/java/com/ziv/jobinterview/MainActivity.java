package com.ziv.jobinterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

/**
 * Created by Ziv on 2016/3/26.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new TextView(this).setError("请正确输入");
        ViewStub viewStub = new ViewStub(this);
        viewStub.setVisibility(View.VISIBLE);
    }

    /**
     * 内存紧张时回调方法，便于主动释放资源，避免OOM
     * @param level 级别
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
