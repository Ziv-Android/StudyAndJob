package com.ziv.jobinterview.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 使用SharedPreferences保存可序列化对象
 * Created by Ziv on 2016/4/26.
 */
public class ObjectSharedPrefs extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Product product = new Product();
        product.setId("3079");
        product.setName("ziv");
        product.setPrice(1000.0f);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将Product对象保存在OutputStream中
            oos.writeObject(product);
            sharedPreferences = getSharedPreferences("object", Activity.MODE_PRIVATE);
            String productBase64 = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            // 保存编码文件
            editor.putString("product", productBase64);
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 取数据
        String productBase64String = sharedPreferences.getString("protect", "");
        byte[] bytes = Base64.decode(productBase64String, Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream ios = new ObjectInputStream(bais);
            product = (Product) ios.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}