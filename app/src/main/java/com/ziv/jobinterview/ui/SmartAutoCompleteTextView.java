package com.ziv.jobinterview.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

/**
 * 实时查询数据库，智能补全，类似百度搜索
 * Created by Ziv on 2016/3/25.
 */
public class SmartAutoCompleteTextView {
    public static void searchEditText(Context context) {
        AutoCompleteTextView editText = new AutoCompleteTextView(context);
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: 2016/3/28 查询数据库更新Adapter
            }
        };
        editText.addTextChangedListener(watcher);
    }
}
