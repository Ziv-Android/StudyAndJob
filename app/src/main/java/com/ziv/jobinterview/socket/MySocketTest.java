package com.ziv.jobinterview.socket;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 使用Socket连接服务器并与服务器交互
 * Created by Ziv on 2016/5/9.
 */
public class MySocketTest {
    public void connect() throws IOException {
        Socket socket = new Socket("192.168.17.100", 8080);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // 向服务器写数据
        bufferedWriter.write("hello world\r\n\r\n");
        bufferedWriter.flush();

        // 操作完成，释放资源
        outputStream.close();
        socket.close();
    }

    public void read(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // 从服务器读数据
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            Log.d("ziv","line = " + s);
        }

        // 操作完成，释放资源
        inputStream.close();
        socket.close();
    }
}
