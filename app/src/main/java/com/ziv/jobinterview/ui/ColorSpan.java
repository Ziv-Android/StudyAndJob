package com.ziv.jobinterview.ui;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/**
 * 自定义Style，满足同时设置文字与背景色
 * Created by Ziv on 2016/3/25.
 */
public class ColorSpan extends CharacterStyle{
    private int mTextColor;
    private int mBackgroundColor;

    public ColorSpan(int mTextColor, int mBackgroundColor) {
        this.mTextColor = mTextColor;
        this.mBackgroundColor = mBackgroundColor;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.bgColor = mBackgroundColor;
        tp.setColor(mTextColor);
    }
}
