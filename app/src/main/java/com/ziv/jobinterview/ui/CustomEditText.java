package com.ziv.jobinterview.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 在EditText中绘制提示文本
 * 1 添加drawableLeft图像
 * 2 使用paddingLeft属性和Canvas绘制（推荐）
 * Created by Ziv on 2016/3/23.
 */
public class CustomEditText extends EditText {
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(18);
        paint.setColor(Color.GRAY);
        // 绘制提示文本
        canvas.drawText("输入提示文本", 2, getHeight() / 2 + 5, paint);
        super.onDraw(canvas);
    }
}
