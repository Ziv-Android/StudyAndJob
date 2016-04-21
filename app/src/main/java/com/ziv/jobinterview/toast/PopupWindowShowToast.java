package com.ziv.jobinterview.toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.ziv.jobinterview.R;

/**
 * 使用PopupWindow对象显示一个类似Toast信息框的窗口
 * Created by Ziv on 2016/4/20.
 */
public class PopupWindowShowToast extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View layout = getLayoutInflater().inflate(R.layout.activity_dialog, null);
        PopupWindow popupWindow = new PopupWindow(layout, 200, 100);
        popupWindow.setTouchable(false);
        popupWindow.showAtLocation(layout, Gravity.CENTER_HORIZONTAL, 20, 0);

        // 关闭窗口的代码
        popupWindow.dismiss();
    }
}
