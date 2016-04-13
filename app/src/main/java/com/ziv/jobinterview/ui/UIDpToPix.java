package com.ziv.jobinterview.ui;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * 自定义视图组件使用，将dp值转换为pix
 * Created by Ziv on 2016/4/1.
 */
public class UIDpToPix {
    public void tool(int dip) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        // 根据屏幕分辨率将dp值转换成像素点
        int pixel = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }
}
