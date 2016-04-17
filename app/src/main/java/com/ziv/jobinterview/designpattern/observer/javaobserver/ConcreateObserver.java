package com.ziv.jobinterview.designpattern.observer.javaobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者对象
 * Created by Ziv on 2016/4/14.
 */
public class ConcreateObserver implements Observer{
    //观察者名称对象
    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    /**
     * 更新
     * @param observable 目标对象的引用
     * @param data 推送过来的信息
     */
    @Override
    public void update(Observable observable, Object data) {
        // 推方式实现
        android.util.Log.e("ziv","ConcreateObserver update , push " + observerName + " = " + data);

        // 拉的方式实现
        android.util.Log.e("ziv","ConcreateObserver update , pull "+ ((ConcreteSubject)observable).getContent());
    }
}
