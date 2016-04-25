package com.ziv.jobinterview.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ziv.jobinterview.R;

/**
 * 显示一个AlertDialog
 * Created by Ziv on 2016/4/19.
 */
public class AlertDialogActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dialog);
        // 创建简单对话框
        new AlertDialog.Builder(this).setTitle("我的对话框").setPositiveButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 响应按钮点击事件

            }
        });
        // 创建列表对话框
        final String[] provinces = new String[]{"广东省", "辽宁省", "山东省", "河北省", "福建省", "黑龙江省"};
        // 创建一个新的Dialog显示列表（不建议这样使用），
        // 如果要多个Dialog建议使用popupWindow，或一个Dialog使用多个布局
        new AlertDialog.Builder(this).setTitle("选择省份")
                .setItems(provinces, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new AlertDialog.Builder(AlertDialogActivity.this)
                                .setMessage("您选择了: " + which + " : " + provinces[which])
                                .show();
                    }
                }).show();
        // 创建单选列表对话框
        new AlertDialog.Builder(this).setTitle("选择省份")
                .setSingleChoiceItems(provinces, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        new AlertDialog.Builder(AlertDialogActivity.this)
                                .setMessage("您选择了: " + which + " : " + provinces[which])
                                .show();
                    }
                })
                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2016/4/19 此处不明白 which 是什么含义
                        new AlertDialog.Builder(AlertDialogActivity.this)
                                .setMessage("您选择了: " + which + " : " + provinces[which])
                                .show();
                    }
                }).show();

        // 多选列表
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("选择省份")
                .setMultiChoiceItems(provinces, new boolean[provinces.length]
                        , new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int count = lv.getCount();
                        String s = "您选择了";
                        for (int i = 0; i < provinces.length; i++) {
                            if (lv.getCheckedItemPositions().get(i)) {
                                s += i + " : " + lv.getAdapter().getItem(i) + " ";
                            }
                        }
                        if (lv.getCheckedItemPositions().size() > 0) {
                            new AlertDialog.Builder(AlertDialogActivity.this).show();
                        }else {
                            new AlertDialog.Builder(AlertDialogActivity.this).setMessage("您未选择任何省份").show();
                        }
                    }
                }).setNegativeButton("取消", null).create();
        lv = dialog.getListView();
        dialog.show();
    }
}
