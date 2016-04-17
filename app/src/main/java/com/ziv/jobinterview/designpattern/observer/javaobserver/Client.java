package com.ziv.jobinterview.designpattern.observer.javaobserver;


/**
 * 测试功能是否实现
 * Created by Ziv on 2016/4/14.
 */
public class Client {

    public static void test(){
        //创建被观察者
        ConcreteSubject subject = new ConcreteSubject();

        //创建观察者1
        ConcreateObserver girl = new ConcreateObserver();
        girl.setObserverName("xia");

        //创建观察者2
        ConcreateObserver mum = new ConcreateObserver();
        mum.setObserverName("xiang");

        //注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);

        //目标更新内容
        subject.setContent("love");
    }
}
