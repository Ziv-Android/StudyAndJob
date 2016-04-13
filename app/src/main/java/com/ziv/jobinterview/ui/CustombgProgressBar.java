package com.ziv.jobinterview.ui;

import android.graphics.drawable.ClipDrawable;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ziv.jobinterview.R;

/**
 * 自定义进度条颜色
 * Created by Ziv on 2016/3/30.
 */
public class CustombgProgressBar {
    public ProgressBar progressBar;
    public void bgColor(){
        progressBar.setBackgroundResource(R.drawable.progressbar);
    }

    public void verticalProgressBar(ImageView imageView){
        ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        // 从顶端截取30%
        // TODO: 2016/3/30 个人认为有问题，需要添加Clip规则
        drawable.setLevel(3000);
    }
}
