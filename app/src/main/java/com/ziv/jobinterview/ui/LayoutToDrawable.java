package com.ziv.jobinterview.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将布局存成图像，屏幕截图
 * Created by Ziv on 2016/3/20.
 */
public class LayoutToDrawable {

    private FileOutputStream fos;

    public void screenCapture(Window window, int layoutSource) {
        View view = window.getLayoutInflater().inflate(layoutSource, null);
        // 打开图像缓存
        view.setDrawingCacheEnabled(true);
        // 必须调用measure和layout方法才能成功保存可视组件的截图到png图像文件
        // 测量View的大小
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        // 发送位置和尺寸到View及其所有的子View
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        try {
            // 获取可视组件的截图
            Bitmap bitmap = view.getDrawingCache();
            fos = new FileOutputStream("sdcard/test.png");
            // 将Bitmap对象中的图像数据压缩成png格式的图像数据，并将这些数据保存在test.png文件中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            // 操作完毕，文件流关闭，防止内存泄露
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
