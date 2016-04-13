package com.ziv.jobinterview.ui;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

/**
 * 对ColorSpan类的应用
 * Created by Ziv on 2016/3/25.
 */
public class UseColorSpan {
    public static void custom(TextView textView){
        String text = "<没有背景><黄色背景>\n<蓝色背景，红色文字>";
        SpannableString spannableString = new SpannableString(text);
        int start = 6;
        int end = 12;
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
        spannableString.setSpan(backgroundColorSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // <蓝色背景，红色文字>子字符串的开始位置（每一个“\n”算一个长度）
        start = 14;
        // 创建ColorSpan对象
        ColorSpan colorSpan = new ColorSpan(Color.RED,Color.BLUE);
        spannableString.setSpan(colorSpan,start,text.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }
}