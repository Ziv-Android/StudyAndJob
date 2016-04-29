package com.ziv.jobinterview.SQLite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Android支持三种打开或创建SQLite数据库的方式
 * SQLiteOpenHelper
 * Context.openOrCreateDatabase
 * SQLiteDatabase.openOrCreateDatabase
 * Created by Ziv on 2016/4/29.
 * TODO: 2016/4/29 未完成具体实现，心烦，有时间再说吧
 */
public class OpenSQLite extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 第一种
//        SQLiteOpenHelper openHelper = new SQLiteOpenHelper() {
//            @Override
//            public void onCreate(SQLiteDatabase db) {
//
//            }
//
//            @Override
//            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//            }
//        };

        // 第二种
        //Context.openOrCreateDatabase(String name, int mode, CursorFactory factory);

        // 第三种
        //SQLiteDatabase.openOrCreateDatabase(String path, CursorFactory factory);
    }
}
