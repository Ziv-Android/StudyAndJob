package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * 实现渐变色背景
 * Created by Ziv on 2016/3/23.
 */
public class GradualBackgroud {
    public static void myBackgroud(Activity context) {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[]{Color.GREEN, Color.BLUE, Color.RED});
        // 设置窗口背景色
        context.getWindow().setBackgroundDrawable(gradientDrawable);
    }
}
