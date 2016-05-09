package com.ziv.jobinterview.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 使用Socket.connect方法连接服务器
 * Created by Ziv on 2016/5/9.
 */
public class SocketConnect {
    public void connect() throws IOException {
        Socket socket = new Socket();
        // 2000为连接超时时间
        socket.connect(new InetSocketAddress("192.168.0.1", 8080), 2000);
        // 读取数据超时
        socket.setSoTimeout(0);
    }
}
