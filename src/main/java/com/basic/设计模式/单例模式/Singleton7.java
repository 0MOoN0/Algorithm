package com.basic.设计模式.单例模式;

public class Singleton7 {
    // 使用volatile时防止指令重排序，保证对象可见，防止读到半初始化状态的对象
    private volatile static Singleton7 singleton;

    private Singleton7() {
    }

    public static Singleton7 getSingleton() {
        // 防止有多个线程同时创建
        if (singleton == null) {
            // 加锁防止多个线程同时进入该方法创建对象
            synchronized (Singleton7.class) {
                // 防止有多个线程等待锁后执行创建对象
                if (singleton == null) {
                    singleton = new Singleton7();
                }
            }
        }
        return singleton;
    }
}