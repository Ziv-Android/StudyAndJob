package com.ziv.jobinterview.designpattern.observer;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * Created by Ziv on 2016/4/13.
 */
public class ConcerteObserver implements Observer{
    // 观察者状态
    private String observerState;

    /**
     * 获取目标类的状态，并同步到观察者的状态中
     * @param subject 传入目标对象，方便获取相应的目标对象的状态
     */
    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getSubjectState();
    }
}
