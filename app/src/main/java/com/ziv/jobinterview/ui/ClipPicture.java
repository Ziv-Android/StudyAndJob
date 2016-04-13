package com.ziv.jobinterview.ui;

import android.graphics.drawable.ClipDrawable;
import android.widget.ImageView;

/**
 * 图像剪切效果，必须配合clip的资源文件才可以使用，必要的情况下可以实现水平or垂直进度条的效果
 * Created by Ziv on 2016/4/10.
 */
public class ClipPicture {
    public static void go(ImageView imageView){
        ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        //图像左侧开始截取30%，系统预定义10000为100%，clipOrication决定方向
        drawable.setLevel(3000);
    }
}
