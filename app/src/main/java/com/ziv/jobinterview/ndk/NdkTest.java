package com.ziv.jobinterview.ndk;

/**
 * Ndk测试使用
 * Created by Ziv on 2016/4/15.
 */
public class NdkTest {
    static {
        System.loadLibrary("NdkTest");
    }
    public static native String getString();
}
