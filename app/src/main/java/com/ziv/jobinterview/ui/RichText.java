package com.ziv.jobinterview.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.ziv.jobinterview.R;

/**
 * TextView显示图像信息，富文本
 * Created by Ziv on 2016/3/23.
 */
public class RichText {

    /**
     * 使用<img>标签在TextView中显示图像
     *
     * @param context  获取图片资源的上下文对象
     * @param textView 用于显示图文混排富文本TextView
     * @param html     用于解析标签的对象
     */
    public static void useImgLable(final Context context, TextView textView, String html) {
        CharSequence charSequence = Html.fromHtml(html, new Html.ImageGetter() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public Drawable getDrawable(String source) {
                // 装载图像资源
                Drawable drawable = context.getResources().getDrawable(R.mipmap.ic_launcher, null);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                return drawable;
            }
        }, null);
        textView.setText(charSequence);
    }

    /**
     * 使用ImageSpan对象在TextView组件中显示图像
     *
     * @param context  获取图片资源的上下文对象
     * @param textView 用于显示图文混排富文本TextView
     */
    public static void useImageSpan(Context context, TextView textView) {
        // 根据资源ID获得资源图像的Bitmap对象
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        // 根据Bitmap对象创建ImageSpan对象
        ImageSpan imageSpan = new ImageSpan(context, bitmap);
        // 创建一个SpannableString对象，以便插入ImageSpan封装的图像
        SpannableString spannableString = new SpannableString("icon");
        // 用ImageSpan对象替换icon
        spannableString.setSpan(imageSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 将图像显示在TextView组建上
        textView.setText(spannableString);
    }

    public static void setTextBackgroundColor(TextView textView){
        String text = "带背景色的文本";
        // 将字符串转化为SpannableString对象
        SpannableString spannableString = new SpannableString(text);
        // 确定要设置的子字符串的start和end
        int start = 0;
        int end = 7;
        // 创建BackgroundColorSpan对象，指定背景色为黄色
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
        // 使用setSpan方法将指定子字符串转换成BackgroundColorSpan对象
        spannableString.setSpan(backgroundColorSpan,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 将SpannableString对象设置TextView控件
        textView.setText(spannableString);
    }
}
