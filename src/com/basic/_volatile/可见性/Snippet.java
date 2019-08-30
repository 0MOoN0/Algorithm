package com.basic._volatile.�ɼ���;

import java.util.concurrent.TimeUnit;

/**
 * �����ɼ�������
 * δʹ��volatile����ʱ���̲߳���ֹͣ
 * ʹ��volatile���κ��̻߳�ֹͣ
 * @author Peter
 *
 */
public class Snippet {
	private static boolean stopRequested;
//	private static volatile boolean stopRequested;

	public static void main(String [] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"Thread Running...");
				int i = 0;
				while (!stopRequested) {
					++i;
				}
				System.out.println(Thread.currentThread().getName()+"Thread Mession Done...");
			}
		});
		t.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		System.out.println("stopRequested has been change to "+stopRequested);
	}

}
