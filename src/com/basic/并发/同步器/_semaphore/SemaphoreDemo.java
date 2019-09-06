package com.basic.����.ͬ����._semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * ��������������λ
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
					System.out.println(Thread.currentThread().getName()+"\t����һ����λ");
					try {
						// ������λ����ռ��3��
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(Exception e) {
					
				}
				finally {
					// �ͷ���Դ
					System.out.println(Thread.currentThread().getName()+"\t�뿪��λ");
					semaphore.release();
				}
			}
					,String.valueOf(i)).start();
		}
		
	}

}
