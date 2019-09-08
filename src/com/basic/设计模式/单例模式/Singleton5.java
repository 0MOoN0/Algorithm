package com.basic.设计模式.单例模式;

/*
 * 懒汉式：
 * 	延迟创建这个实例对象
 * 
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
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
