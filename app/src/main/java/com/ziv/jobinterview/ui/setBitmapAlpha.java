package com.ziv.jobinterview.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.DrawableRes;

import java.io.InputStream;

/**
 * 设置图像透明度
 * Created by Ziv on 2016/3/29.
 */
public class setBitmapAlpha {

    private InputStream is;
    private Bitmap bitmap;
    private int alphaValue;

    public setBitmapAlpha(Context context, int resourceId, int alphaValue) {
        this.is = context.getResources().openRawResource(resourceId);
        // 装载图像
        this.bitmap = BitmapFactory.decodeStream(is);
        this.alphaValue = alphaValue;
    }

    /**
     * 方法一：通过canvas设置透明度，重新绘制
     */
    // View.onDraw
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAlpha(alphaValue);
        canvas.drawBitmap(bitmap,
                new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
                new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
                paint);
    }
}
