package com.ziv.jobinterview.SQLite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.ziv.jobinterview.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 操作数据库文件，使App自带本地数据库
 * Created by Ziv on 2016/4/29.
 */
public class DatabaseFile extends AppCompatActivity {
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getPath();
    public static final String FILE_NAME = "/test.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String databaseFilename = SDCARD_PATH + FILE_NAME;
        // 文件不存在则将res/raw目录中的数据库文件复制到SD卡的根目录
        if (!(new File(databaseFilename).exists())) {
            InputStream is = getResources().openRawResource(R.raw.test);
            try {
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[1024 * 8];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 打开数据库
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFilename, null);
        // 进行数据库的其他操作


        // 操作完成关闭数据库
        database.close();
    }
}
