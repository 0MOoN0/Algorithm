package com.interview.�㷨.��.Q2_stack_queue;

/**
 * ������ʵ��һ���̶����ȵ�ջ
 * �涨��index��ʼΪ0��ָ����һ����ջ�Ŀռ䣻
 * ����ջ�Ĵ�СΪ2����ջ��ʱindexΪ2��ջ��ʱindexΪ0�������ջ��Ҫ����ջ,index++;��ջ��Ҫ��--index���ٳ�ջ
 * @author Peter
 *
 */
public class Array_To_Stack {
	private Integer index;
	private Integer [] arr;

	// for test
	public static void main(String[] args) {
		Array_To_Stack stack = new Array_To_Stack(2);
		try {
			stack.push(1);
			System.out.println(stack.peek());
			System.out.println(stack.pop());
			stack.push(1);
			stack.push(2);
			stack.push(3);
		} catch (Exception e) {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}
	}

	public Array_To_Stack(int size) {
		this.index=0;
		this.arr = new Integer[size];
	}
	
	public Integer peek() {
		if(index==0) {
			return null;
		}
		return arr[index-1];
	}
	
	public void push(int num) {
		if(index == arr.length) {
			throw new RuntimeException("ջ����");
		}
		arr[index++] = num;
	}
	
	public Integer pop() {
		if(index==0) {
			throw new RuntimeException("ջ�ѿ�");
		}
		return arr[--index];
	}
	
}
