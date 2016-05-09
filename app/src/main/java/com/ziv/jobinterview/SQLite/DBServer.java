package com.ziv.jobinterview.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库访问服务类
 * Created by Ziv on 2016/4/29.
 */
public class DBServer extends SQLiteOpenHelper{

    public DBServer(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 执行查询语句
     */
    public Cursor query(String sql,String[] args){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, args);
        return cursor;
    }

    /**
     * 数据库的创建
     * 需要创建数据库中的表、视图等组件，
     * 创建之前数据库是空的，因此不需要先删除数据库中相关的组件
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    /**
     * 数据库的升级
     * 数据库存在，并且当前的版本号高于上次创建或升级时的版本号
     * 除了创建表、视图等组件外，还需要首先删除这些相关组件
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
