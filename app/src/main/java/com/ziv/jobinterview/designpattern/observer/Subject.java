package com.ziv.jobinterview.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，她知道观察它的观察者，并提供注册和删除观察者的接口
 * Created by Ziv on 2016/4/13.
 */
public class Subject {
    // 用来保存注册的观察者对象
    private List<Observer> observers = new ArrayList<>();

    // attach detach notifyObservers

    /**
     * 添加观察者对象到观察者集合中
     * @param observer 需要添加的观察者
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 删除集合中的指定观察者
     * @param observer 需要删除的观察者对象
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    protected void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
