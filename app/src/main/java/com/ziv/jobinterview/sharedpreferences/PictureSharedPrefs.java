package com.ziv.jobinterview.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 使用SharedPreferences保存图像数据
 * Created by Ziv on 2016/4/26.
 */
public class PictureSharedPrefs extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("Base64Picture", Activity.MODE_PRIVATE);
        // 用于保存图像数据的流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 将ImageView组件中的图像压缩成JPEG格式，并将压缩结果保存在ByteArrayOutputStream对象中
        ((BitmapDrawable) imageView.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 50, baos);
        String imageBase64 = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("picture", imageBase64);
        editor.apply();

        // 取数据
        String picture = sharedPreferences.getString("picture", "");
        byte[] bytes = Base64.decode(picture, Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        // 在imageView上显示图像
        imageView.setImageDrawable(Drawable.createFromStream(bais, "product_image"));
    }
}
