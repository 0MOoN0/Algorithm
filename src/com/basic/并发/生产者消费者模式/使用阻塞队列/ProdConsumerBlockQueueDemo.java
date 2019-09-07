package com.basic.����.������������ģʽ.ʹ����������;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    /**
     * Ĭ�Ͽ��� �����������ѵĽ���
     */
    private volatile boolean flag = true;
    /**
     * Ĭ��ֵ��0
     */
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean returnValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "\t �����������" + data + "�ɹ�");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t �����������" + data + "ʧ��");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t ֹͣ ��ʾ flag" + flag);
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null==result||"".equalsIgnoreCase(result)){
                flag=false;
                System.out.println(Thread.currentThread().getName()+"\t"+"����2mû��ȡ�� �����˳�");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "���Ѷ���" + result + "�ɹ�");

        }
    }
    public void stop() throws Exception{
        flag=false;
    }
}

/**
 * Description
 * volatile/CAS/atomicInteger/BlockQueue/�߳̽���/ԭ������
 *
 * @author veliger@163.com
 * @version 1.0
 * @date 2019-04-13 14:02
 **/
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t�����߳�����");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t�����߳�����");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ʱ�䵽,ֹͣ�");
        myResource.stop();
    }
}
 
