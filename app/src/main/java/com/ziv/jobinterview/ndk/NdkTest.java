package com.ziv.jobinterview.ndk;

import android.app.Activity;

/**
 * Ndk测试使用
 * Created by Ziv on 2016/4/15.
 */
public class NdkTest extends Activity{
    static {
        System.loadLibrary("NdkTest");
    }
    public static native String getString();
}
