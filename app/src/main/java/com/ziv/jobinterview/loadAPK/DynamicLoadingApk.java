package com.ziv.jobinterview.loadapk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexFile;

/**
 * 动态加载APK资源
 * 1 使用DexFile装载apk文件
 * 2 使用dexFile.loadClass装载接口，类
 * 3 使用反射获取Method对象
 * 4 调用类方法
 *
 * 注：如果apk文件中的类实现了接口，或继承了其他的类，必须同时装载这些接口和类，
 * 否则无法成功创建该类对象
 * 使用强类型访问apk文件的类，一般需要将类实现的接口提供给调用者，也可以使用AIDL文件
 *
 * Created by Ziv on 2016/4/1.
 */
public class DynamicLoadingApk {
    public void go() throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // my.apk表示要动态装载的apk文件，my_temp.apk表示为了优化临时产生的apk文件(由系统处理)
        DexFile dexFile = dalvik.system.DexFile.loadDex("要动态装载的apk文件","为了优化临时产生的apk文件",0);
        // 装载apk文件中的类，创建构造该类的对象
        Object object = dexFile.loadClass("创建构造该类的对象",null).newInstance();
        // 使用Java反射技术获取getName方法的Method对象
        Method method = object.getClass().getMethod("getName",null);
        // 调用类中的方法，获取方法返回值
        String result = String.valueOf(method.invoke(object,null));
    }
}
