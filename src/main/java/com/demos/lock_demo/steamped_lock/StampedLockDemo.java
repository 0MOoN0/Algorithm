package com.demos.lock_demo.steamped_lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    // 创建一个StampedLock实例
    private final StampedLock lock = new StampedLock();

    // 定义一个共享的数据
    private int data = 0;

    // 定义一个写入数据的方法，需要获取写锁
    public void writeData(int newData) {
        long stamp = lock.writeLock(); // 获取写锁
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入数据...");
            Thread.sleep(1000); // 模拟写入耗时
            data = newData;
            System.out.println(Thread.currentThread().getName() + "写入的数据是：" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp); // 释放写锁
        }
    }

    // 定义一个读取数据的方法，需要获取读锁
    public int readData() {
        long stamp = lock.readLock(); // 获取读锁
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取数据...");
            Thread.sleep(1000); // 模拟读取耗时
            System.out.println(Thread.currentThread().getName() + "读取到的数据是：" + data);
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp); // 释放读锁
        }
        return -1;
    }

    // 定义一个乐观读取数据的方法，需要获取乐观读锁
    public int optimisticReadData() {
        long stamp = lock.tryOptimisticRead(); // 获取乐观读锁
        try {
            System.out.println(Thread.currentThread().getName() + "正在乐观读取数据...");
            Thread.sleep(1000); // 模拟读取耗时
            if (lock.validate(stamp)) { // 验证戳记是否有效
                System.out.println(Thread.currentThread().getName() + "乐观读取到的数据是：" + data);
                return data;
            } else { // 戳记无效，说明发生了写操作，需要重新获取锁
                System.out.println(Thread.currentThread().getName() + "乐观读取失败，尝试重新获取锁...");
                return readData(); // 调用普通的读取方法
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        // 创建一个StampedLockDemo对象
        StampedLockDemo demo = new StampedLockDemo();

        // 创建三个线程分别进行写入、读取和乐观读取操作
        Thread t1 = new Thread(() -> {
            demo.writeData(10); // 写入10
        }, "t1");

        Thread t2 = new Thread(() -> {
            demo.readData(); // 读取数据
        }, "t2");

        Thread t3 = new Thread(() -> {
            demo.optimisticReadData(); // 乐观读取数据
        }, "t3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
