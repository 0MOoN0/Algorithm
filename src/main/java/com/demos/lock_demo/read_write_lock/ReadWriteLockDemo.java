package com.demos.lock_demo.read_write_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    // 创建一个ReadWriteLock实例
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 获取读锁和写锁
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    // 定义一个共享的数据
    private int data = 0;

    // 定义一个读取数据的方法，需要获取读锁
    public int readData() {
        readLock.lock(); // 获取读锁
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取数据...");
            Thread.sleep(1000); // 模拟读取耗时
            System.out.println(Thread.currentThread().getName() + "读取到的数据是：" + data);
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock(); // 释放读锁
        }
        return -1;
    }

    // 定义一个写入数据的方法，需要获取写锁
    public void writeData(int newData) {
        writeLock.lock(); // 获取写锁
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入数据...");
            Thread.sleep(1000); // 模拟写入耗时
            data = newData;
            System.out.println(Thread.currentThread().getName() + "写入的数据是：" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock(); // 释放写锁
        }
    }

    public static void main(String[] args) {
        // 创建一个ReadWriteLockDemo对象
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        // 创建三个线程分别进行读取和写入操作
        Thread t1 = new Thread(() -> {
            demo.writeData(10); // 写入10
        }, "t1");

        Thread t2 = new Thread(() -> {
            demo.readData(); // 读取数据
        }, "t2");

        Thread t3 = new Thread(() -> {
            demo.writeData(20); // 写入20
        }, "t3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}