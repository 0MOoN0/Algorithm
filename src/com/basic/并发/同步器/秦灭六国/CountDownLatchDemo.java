package com.basic.并发.同步器.秦灭六国;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(6);
		for (int i = 1; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 被灭");
				latch.countDown();
			}
			,CountryEnum.forEach(i).getName()).start();
		}
		latch.await();
		System.out.println("秦国统一");
	}

}
