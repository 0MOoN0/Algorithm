package com.basic._锁.自旋锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 写一个自旋锁
 * @author Peter
 *
 */
public class SpinLockDemo {
	
	AtomicReference<Thread> reference = new AtomicReference<Thread>();
	
	public void myLock() {
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"Come in ...");
		// 如果当前原子引用已经有值，则循环等待，直到reference的值为null为止
		while(!reference.compareAndSet(null, thread)) {
		}
		System.out.println(Thread.currentThread().getName()+"Locking ...");
	}
	public void myUnlock() {
		Thread thread = Thread.currentThread();
		reference.compareAndSet(thread, null);
		System.out.println(Thread.currentThread().getName()+"invoked myUnlock...");
	}
	

	
	public static void main(String[] args) {
		
		SpinLockDemo lockDemo = new SpinLockDemo();
		new Thread(() -> {
			lockDemo.myLock();
			try {
				TimeUnit.SECONDS.sleep(5);
				lockDemo.myUnlock();
			} catch (Exception e) {
			}
		},"AA").start();
		new Thread(() -> {
			lockDemo.myLock();
			try {
				TimeUnit.SECONDS.sleep(1);
				lockDemo.myUnlock();
			} catch (Exception e) {
			}
		},"BB").start();

	}

}
