package com.basic.����.ͬ����._countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch����
 * @author Peter
 *
 */
public class CountDownLatchDemo {
	

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(6);
		for (int i = 0; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t �߳�ִ�����");
				latch.countDown();
			},String.valueOf(i)).start();
		}
		latch.await();
		System.out.println("�����߳�ִ����ϣ����̷߳���ִ�����");
	}

}
