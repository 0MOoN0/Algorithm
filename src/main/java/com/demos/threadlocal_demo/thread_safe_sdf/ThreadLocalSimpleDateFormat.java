package com.demos.threadlocal_demo.thread_safe_sdf;

import java.text.SimpleDateFormat;
import java.util.Date;

// 线程安全的SimpleDataFormat
public class ThreadLocalSimpleDateFormat {
    // 创建一个ThreadLocal对象
    private static final ThreadLocal<SimpleDateFormat> threadLocalSdf = new ThreadLocal<>();

    // 在线程开始前设置SimpleDateFormat实例
    public void beforeExecute(Thread t, Runnable r) {
        // 创建SimpleDateFormat实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 设置到当前线程中
        threadLocalSdf.set(sdf);
    }

    // 在线程执行过程中获取SimpleDateFormat实例
    public void execute(Runnable r) {
        // 获取当前线程的SimpleDateFormat实例
        SimpleDateFormat sdf = threadLocalSdf.get();
        // 使用SimpleDateFormat实例进行日期和时间格式化
        String date = sdf.format(new Date());
        System.out.println(date);
    }

    // 在线程执行结束后清除SimpleDateFormat实例
    public void afterExecute(Runnable r, Throwable t) {
        // 清除当前线程的SimpleDateFormat实例
        threadLocalSdf.remove();
    }

}
