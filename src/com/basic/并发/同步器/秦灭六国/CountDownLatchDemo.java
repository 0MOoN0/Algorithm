package com.basic.����.ͬ����.��������;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(6);
		for (int i = 1; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t ����");
				latch.countDown();
			}
			,CountryEnum.forEach(i).getName()).start();
		}
		latch.await();
		System.out.println("�ع�ͳһ");
	}

}
