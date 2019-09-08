package com.basic.���ģʽ.����ģʽ;

/*
 * ����ʽ��
 * 	�ӳٴ������ʵ������
 * 
 * (1)������˽�л�
 * (2)��һ����̬�����������Ψһ��ʵ��
 * (3)�ṩһ����̬��������ȡ���ʵ������
 */
public class Singleton5 {
	private static volatile Singleton5 INSTANCE;
	private Singleton5(){
		
	}
	public static Singleton5 getInstance(){
		if(INSTANCE == null){
			synchronized (Singleton5.class) {
				if(INSTANCE == null){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					INSTANCE = new Singleton5();
				}
			}
		}
		return INSTANCE;
	}
}
