package com.ziv.jobinterview.ui;

/**
 * Created by Ziv on 2016/4/11.
 */
public class ScanTaskThread implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                //每100毫秒扫描任务对队列获取并处理任务

                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
