package com.ziv.jobinterview.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * 自定义ContentProvider实现
 * Created by Ziv on 2016/4/18.
 */
public class MyContentProvider extends ContentProvider {
    public static final String AUTHORITY = "com.ziv.jobinterview.provider.MyContentProvider";
    private static UriMatcher uriMatcher;

    static {
        // 开始映射Uri和返回码
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "cities", 1);
        uriMatcher.addURI(AUTHORITY, "code/#", 2);// #表示任意数字
        uriMatcher.addURI(AUTHORITY, "cities_in_province/*", 3);// *表示任意字符
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        // 根据Uri获得返回码
        int match = uriMatcher.match(uri);
        switch (match) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                throw new IllegalArgumentException("<" + uri + "> 格式不正确");
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
