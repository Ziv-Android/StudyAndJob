package com.ziv.jobinterview.designpattern.observer;

/**
 * 具体的目标类，负责把有关状态存入到相应的观察者对象中
 * Created by Ziv on 2016/4/13.
 */
public class ConcreteSubject extends Subject{
    // 目标对象的状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        // 通知观察者目标状态发生改变
        this.notifyObservers();
    }

}
