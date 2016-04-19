package com.ziv.jobinterview.provider.cantacts;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.ziv.jobinterview.R;

/**
 * 使用Content Provider读取联系人信息，并显示在ListView组件中
 * Created by Ziv on 2016/4/18.
 */
public class ContactsListView extends AppCompatActivity {
    private ListView listView;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_content_contacts);
        listView = (ListView) findViewById(R.id.listview);
        // 查询系统中所有的联系人
        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        // 根据cursor创建SimpleCursorAdapter对象
        simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, cursor,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(simpleCursorAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        simpleCursorAdapter.notifyDataSetInvalidated();
    }
}
