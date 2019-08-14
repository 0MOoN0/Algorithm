package com.object;

/**
 * 方法测试
 * @author Peter
 *
 */
public class MethodTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// 对象浅克隆
		int x[] = new int [10];
		System.out.println(x.clone().equals(x));

	}

}
