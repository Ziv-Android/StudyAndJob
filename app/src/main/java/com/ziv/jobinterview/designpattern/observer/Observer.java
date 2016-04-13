package com.ziv.jobinterview.designpattern.observer;

/**
 * 这是一个观察者接口，定义一个更新的接口，给那些在目标发生变化的 时候被通知的对象
 * Created by Ziv on 2016/4/13.
 */
public interface Observer {
    /**
     * 更新的接口
     * @param subject 传入目标对象，方便获取相应的目标对象的状态
     */
    public void update(Subject subject);
}
