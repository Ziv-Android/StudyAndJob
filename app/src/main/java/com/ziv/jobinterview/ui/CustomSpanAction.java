package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.ziv.jobinterview.MainActivity;

/**
 * 对android.text.style包中的Span对象动作的自定义
 * Created by Ziv on 2016/3/25.
 */
public class CustomSpanAction {
    public static void startActivity(TextView textView) {
        String text = "显示Activity";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //Intent intent = new Intent(MainActivity.class, MainActivity.class);
                //startActivity(intent);
            }
        }, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 使用SpannableString对象设置两个TextView组件的内容
        textView.setText(spannableString);
        // 在单击链接时，凡是有要执行的动作，都必须设置MovementMethod对象
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
