package com.ziv.jobinterview.IOStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.widget.ImageView;

/**
 * 将SD卡中的图像文件，加载在ImageView中
 * Created by Ziv on 2016/4/26.
 */
public class SDFileToImageView {
    private static String PATH_SDCARD = Environment.getExternalStorageDirectory().getPath();

    public void load(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(Drawable.createFromPath(PATH_SDCARD + "/face.png"));
    }
}
