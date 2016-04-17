//
// Created by Ziv on 2016/4/15.
//
#include "../../../../../jni/com_ziv_jobinterview_ndk_NdkTest.h"
JNIEXPORT jstring JNICALL Java_com_ziv_jobinterview_ndk_NdkTest_getString(JNIEnv *env, jclass jc)
{
    return env-&gt;NewStringUTF("Hello word !!!");
}

