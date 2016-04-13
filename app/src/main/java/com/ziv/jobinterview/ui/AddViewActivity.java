package com.ziv.jobinterview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ziv.jobinterview.R;

/**
 * 动态在该布局中添加一个Button/View
 */
public class AddViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        // 装载布局文件
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_add_view, null);
        // 装载要动态添加的布局
        Button button = (Button) getLayoutInflater().inflate(R.layout.button_custom_view, null);
        // 创建一个LayoutParams
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过LayoutParams.addRule()添加属性
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        // 更新Button按钮中相应的属性值
        button.setLayoutParams(layoutParams);
        // 向RelativeLayout动态添加一个按钮
        relativeLayout.addView(button);
    }
}
