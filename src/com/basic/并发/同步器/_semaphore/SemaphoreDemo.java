package com.basic.并发.同步器._semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 六部车抢三个车位
 * @author Peter
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		
		for (int i = 0; i < 6; i++) {
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"\t抢到一个车位");
					try {
						// 抢到车位，并占用3秒
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(Exception e) {
					
				}
				finally {
					// 释放资源
					System.out.println(Thread.currentThread().getName()+"\t离开车位");
					semaphore.release();
				}
			}
					,String.valueOf(i)).start();
		}
		
	}

}
