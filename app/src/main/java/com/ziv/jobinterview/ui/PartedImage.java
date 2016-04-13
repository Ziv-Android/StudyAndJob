package com.ziv.jobinterview.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * 图片分割显示
 * Created by Ziv on 2016/3/29.
 */
public class PartedImage {
    private ImageView imageView;

    public void show(Bitmap sourceBitmap) {
        Bitmap smallBitmap = Bitmap.createBitmap(sourceBitmap, 20, 20, 100, 100);
        imageView.setImageBitmap(smallBitmap);
    }

    public void percentShow(View view,int imageId){
        ImageView imageView = (ImageView) view.findViewById(imageId);
        ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        // 系统预定义级别0~10000
        drawable.setLevel(300);
    }
}
