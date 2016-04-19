package com.ziv.jobinterview.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ziv.jobinterview.MainActivity;
import com.ziv.jobinterview.R;

/**
 * Activity进入与退出淡入淡出效果
 * Created by Ziv on 2016/4/18.
 */
public class FadeAnimActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // 通过淡入淡出效果显示和关闭Activity
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
