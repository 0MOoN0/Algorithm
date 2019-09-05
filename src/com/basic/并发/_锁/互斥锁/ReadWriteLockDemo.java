package com.basic.����._��.������;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��Դ��
 */
class MyCaChe {
    /**
     * ��֤�ɼ���
     */
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantLock lock = new ReentrantLock();

    /**
     * д
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        reentrantReadWriteLock.writeLock().lock();
//    	lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t����д��" + key);
            //ģ��������ʱ
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\tд�����"+ key);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
//        	lock.unlock();
        }
    }

    /**
     * ��
     *
     * @param key
     */
    public void get(String key) {
        reentrantReadWriteLock.readLock().lock();
//    	lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t���ڶ�ȡ");
            //ģ��������ʱ
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t��ȡ���" + result);
        } finally {
            reentrantReadWriteLock.readLock().unlock();
//        	lock.unlock();
        }
    }

    public void clearCaChe() {
        map.clear();
    }

}

/**
 * Description:
 * ����߳�ͬʱ���� һ����Դ��û���κ����� ����Ϊ�����㲢����
 * ��ȡ������ԴӦ�ÿ���ͬʱ����
 * ����
 * �����һ���߳���ȥд������Դ��  �Ͳ�Ӧ���������߳̿��Զ���Դ���ж���д
 * <p>
 * С�ܽ�:
 * �� ���ܹ���
 * �� д���ܹ���
 * д д���ܹ���
 * д���� ԭ��+��ռ �������̱�����һ����ɵ�ͳһ���� �м䲻�����ָ� �����
 *
 * @author veliger@163.com
 * @date 2019-04-13 0:45
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCaChe myCaChe = new MyCaChe();
        for (int i = 1; i <= 20; i++) {
            final int temp = i;
            new Thread(() -> {
                myCaChe.put(temp + "", temp);
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            new Thread(() -> {
                myCaChe.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}
 
