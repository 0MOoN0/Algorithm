package com.interview.�㷨.��.Q2_3_Array_Stak_Queue;

import com.interview.�㷨.��.Q2_3_Array_Stak_Queue.stack2queue.Stack2Queue;

/**
 * ��ν��ö��нṹʵ��ջ�ṹ��
��ν���ջ�ṹʵ�ֶ��нṹ��
��ҵ�������
 * @author Peter
 *
 */
public class ArrayStackQueue {

	public static void main(String[] args) {

	}
	
	public static void testStack2Queue() {
		Stack2Queue stack = new Stack2Queue(3);
		stack.push(1);
		System.out.println(stack.poll());
		stack.push(2);
		stack.push(3);
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		System.out.println(stack.poll());
	}

}
