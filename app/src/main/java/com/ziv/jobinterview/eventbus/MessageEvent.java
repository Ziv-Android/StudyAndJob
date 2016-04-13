package com.ziv.jobinterview.eventbus;

/**
 * 定义事件消息类
 * Created by Ziv on 2016/3/20.
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
