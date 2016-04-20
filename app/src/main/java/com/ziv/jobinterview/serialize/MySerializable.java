package com.ziv.jobinterview.serialize;

import java.io.IOException;
import java.io.Serializable;

/**
 * 自定义Serializable只需要实现Serializable接口即可
 * 复写writeObject与readObject可实现序列化过程自定义
 * Created by Ziv on 2016/4/20.
 */
public class MySerializable implements Serializable {

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        // write 'this' to 'out'...
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        // populate the fields of 'this' from the data in 'in'...
    }

}
