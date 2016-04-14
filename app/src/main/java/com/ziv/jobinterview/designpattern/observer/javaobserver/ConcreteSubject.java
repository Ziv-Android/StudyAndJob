package com.ziv.jobinterview.designpattern.observer.javaobserver;

import java.util.Observable;

/**
 * 使用Java提供的方法实现观察者模式
 * Created by Ziv on 2016/4/14.
 */
public class ConcreteSubject extends Observable{
    // 定义具体变量
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        // 通知方法的调用
        // 在使用Java中的Observer模式时，通知前必须调用该语句
        this.setChanged();

        // 拉方式
        this.notifyObservers();
        // 推方式
        // this.notifyObservers(content);
    }
}
