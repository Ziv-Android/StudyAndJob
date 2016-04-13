package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

/**
 * ListView显示数据库中的内容
 * Created by Ziv on 2016/4/10.
 */
public class MyCursorListView extends Activity{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Cursor cursor = getContentResolver().query();
        //listView.setAdapter(new MyCursorAdapter(this,android.R.layout.activity_list_item,cursor,new String[]{},new int[]{}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER));
    }
}
