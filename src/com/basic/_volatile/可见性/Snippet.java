package com.basic._volatile.可见性;

import java.util.concurrent.TimeUnit;

/**
 * 变量可见性问题
 * 未使用volatile修饰时，线程不会停止
 * 使用volatile修饰后，线程会停止
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
