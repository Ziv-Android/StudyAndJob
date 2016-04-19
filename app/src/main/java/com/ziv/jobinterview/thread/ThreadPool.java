package com.ziv.jobinterview.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * 模拟线程池的实现
 * Created by Ziv on 2016/4/19.
 */
public class ThreadPool {
    // 定义线程池最大线程数
    private static int WORK_NUMBER = 5;
    // 工作线程
    private WorkThread[] workThreads;
    // 任务缓冲队列
    private List<Runnable> taskQueue = new LinkedList<>();

    private static ThreadPool threadPool;

    /**
     * 默认线程数
     */
    private ThreadPool() {
        this(WORK_NUMBER);
    }

    /**
     * 创建线程池
     * @param work_number 最大工作线程数
     */
    private ThreadPool(int work_number) {
        workThreads = new WorkThread[work_number];
        for (int i = 0; i < work_number; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    /**
     * 获取一个默认线程池
     * @return 默认线程池 work_number = 5
     */
    public static ThreadPool getThreadPool() {
        return getThreadPool(WORK_NUMBER);
    }

    /**
     * 获取一个自定义线程数的线程池
     * @param work_number 自定义工作线程数目
     * @return 自定义线程数目的线程池
     */
    public static ThreadPool getThreadPool(int work_number) {
        if (work_number>0) {
            WORK_NUMBER = work_number;
        }else {
            throw new IllegalArgumentException("work thread number should > 0");
        }
        if (threadPool == null) {
            threadPool = new ThreadPool(work_number);
        }
        return threadPool;
    }

    /**
     * 把任务加入任务队列
     * @param task 需要执行的任务
     */
    public void addTask(Runnable task){
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notifyAll();
        }
    }

    /**
     * 销毁线程池，该方法会保证在所有任务全部完成的情况下执行销毁动作
     * 释放资源，清空任务队列
     */
    public void destroy(){
        while (!taskQueue.isEmpty()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < WORK_NUMBER; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        threadPool = null;
        taskQueue.clear();
    }
    /**
     * 内部类，工作线程
     */
    private class WorkThread extends Thread {
        // 该线程是否有效
        private boolean isRunning = true;
        private Runnable runnable = null;

        /**
         * 如果工作线程有效，而且任务队列不空，取出任务执行
         */
        @Override
        public void run() {
            while (isRunning) {
                synchronized (taskQueue) {
                    while (isRunning && taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        runnable = taskQueue.remove(0);
                    }
                }
                if (runnable != null) {
                    runnable.run();
                }
                runnable = null;
            }
        }

        /**
         * 停止工作，改变工作状态标识
         */
        public void stopWorker() {
            isRunning = false;
        }
    }
}
