package com.ziv.jobinterview.toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ziv.jobinterview.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Toast信息展示
 * Created by Ziv on 2016/4/20.
 */
public class ToastTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 如果使用new关键字创建Toast对象，没有TextView组件，
        // 但有toast.setText方法，若此时调用，则会抛出异常
        Toast textToast = Toast.makeText(this, "我的信息", Toast.LENGTH_LONG);
        textToast.show();

        View view = getLayoutInflater().inflate(R.layout.activity_dialog, null);
        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();

        Toast controlToast = Toast.makeText(this, "永不关闭的Toast", Toast.LENGTH_LONG);

        // 从Toast对象中获得mTN变量
        try {
            // 从Toast对象中会的mTN对象
            Field field = textToast.getClass().getDeclaredField("mTN");
            field.setAccessible(true);
            Object obj = field.get(controlToast);
            // 从TN对象中获取show方法
            Method method = obj.getClass().getDeclaredMethod("show", null);
            // 调用show方法显示Toast信息
            method.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭Toast信息框
        Field field = null;
        try {
            field = textToast.getClass().getDeclaredField("mTN");
            field.setAccessible(true);
            Object obj = field.get(controlToast);
            Method method = obj.getClass().getDeclaredMethod("hide", null);
            method.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
