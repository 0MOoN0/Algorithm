package com.interview.算法.三.Q2_3_Array_Stak_Queue;

import com.interview.算法.三.Q2_3_Array_Stak_Queue.stack2queue.Stack2Queue;

/**
 * 如何仅用队列结构实现栈结构？
如何仅用栈结构实现队列结构？
简单业务测试类
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
