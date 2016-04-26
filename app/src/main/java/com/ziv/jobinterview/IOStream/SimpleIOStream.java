package com.ziv.jobinterview.IOStream;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 流文件
 * Created by Ziv on 2016/4/26.
 */
public class SimpleIOStream {
    private static String PATH_SDCARD = Environment.getExternalStorageDirectory().getPath();
    private FileOutputStream fos;
    private OutputStream os;
    private FileInputStream fis;
    private InputStream is;

    public void fileIOStream() {
        try {
            fos = new FileOutputStream(PATH_SDCARD + "/record.txt");
            byte[] buf = new byte[1024 * 8];
            fos.write(buf);
            fis = new FileInputStream(PATH_SDCARD + "/record.txt");
            fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.flush();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Context.openFileOutput存储文件在/data/data/<package name>/files目录中
     */
    public void openFileIO(Context context) {
        try {
            os = context.openFileOutput("file.txt", Activity.MODE_PRIVATE);
            byte[] buf = new byte[1024 * 8];
            os.write(buf);
            is = context.openFileInput("file.txt");
            is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
