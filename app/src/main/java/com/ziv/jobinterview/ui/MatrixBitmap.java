package com.ziv.jobinterview.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;

/**
 * 通过矩阵变换旋转与缩放图像
 * Created by Ziv on 2016/3/29.
 */
public class MatrixBitmap {
    public ImageView imageView;

    /**
     * 通过Matrix矩阵旋转图像
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void rotate(Context context,int sourceId,Resources.Theme theme){
        // 需要新API21支持
        Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(sourceId, theme)).getBitmap();
        Matrix matrix = new Matrix();
        // 顺时针旋转45度
        matrix.setRotate(45);
        // 旋转图像，并为旋转后的图像创建新的Bitmap对象
        bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        // 显示旋转后的图像
        imageView.setImageBitmap(bitmap);
    }

    /**
     * 通过Matrix矩阵缩放图像
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void scale(Context context,int sourceId,Resources.Theme theme){
        Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(sourceId,theme)).getBitmap();
        Matrix matrix = new Matrix();
        // 图像等比缩小50%
        matrix.setScale(0.5f,0.5f);
        bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        // 显示处理后的图像
        imageView.setImageBitmap(bitmap);
    }
}
