package com.basic.并发.thread_local;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Thread thread = Thread.currentThread();
    }

}
