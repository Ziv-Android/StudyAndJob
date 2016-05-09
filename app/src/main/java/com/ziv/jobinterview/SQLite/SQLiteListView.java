package com.ziv.jobinterview.SQLite;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * 查询数据库表中的内容显示在ListView上
 * 数据库文件保存在/data/data/<package name>/databases
 * 在绑定数据是Cursor返回的记录集中必须包含"_id"的字段，否则无法进行数据绑定
 * Created by Ziv on 2016/4/29.
 */
public class SQLiteListView extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteDatabase.CursorFactory factory = new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return null;
            }
        };
        DBServer dbServer = new DBServer(this,"table1",factory,1);
        String sql = "select id as _id,name from table1";
        Cursor cursor = dbServer.query(sql,null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                cursor,
                new String[]{"name"},
                new int[]{android.R.id.text1}
        );
        listView.setAdapter(simpleCursorAdapter);
    }
}
