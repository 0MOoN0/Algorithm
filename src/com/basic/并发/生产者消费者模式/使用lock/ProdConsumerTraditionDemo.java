package com.basic.����.������������ģʽ.ʹ��lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������Դ��
 */
class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //�ж�
            while (num != 0) {
                //�ȴ� ������
                condition.await();
            }
            //�ɻ�
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //֪ͨ����
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void deIncrement() throws Exception {
        lock.lock();
        try {
            //�ж�
            while (num == 0) {
                //�ȴ� ������
                condition.await();
            }
            //�ɻ�
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //֪ͨ����
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
/**
 * Description
 * һ����ʼֵΪ0�ı��� �����߳̽������ һ����1 һ����1��5��
 *
 * @author veliger@163.com
 * @version 1.0
 * @date 2019-04-13 14:01
 **/
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
//                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
        	for (int i = 1; i <= 5; i++) {
        		try {
        			shareData.deIncrement();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
        }, "CC").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.deIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

    }
}
 
