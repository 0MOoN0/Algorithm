package com.basic.并发.同步器._countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch案例
 * @author Peter
 *
 */
public class CountDownLatchDemo {
	

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(6);
		for (int i = 0; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 线程执行完毕");
				latch.countDown();
			},String.valueOf(i)).start();
		}
		latch.await();
		System.out.println("其他线程执行完毕，主线程方法执行完毕");
	}

}
