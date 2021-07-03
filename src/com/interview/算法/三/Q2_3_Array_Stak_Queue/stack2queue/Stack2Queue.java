package com.interview.算法.三.Q2_3_Array_Stak_Queue.stack2queue;

import com.interview.算法.三.Q2_stack_queue.Array_To_Stack;

/**
 * 使用栈模拟队列
 * @author Peter
 *
 */
public class Stack2Queue {
	
	private Array_To_Stack inStack;
	private Array_To_Stack outStack;
	
	public Stack2Queue(int size) {
		inStack = new Array_To_Stack(size);
		outStack = new Array_To_Stack(size);
	}
	
	public Integer peek() {
		if(outStack.isEmpty()) {
			dumpToOut();
		}
		return outStack.peek();
	}
	
	public void push(int num) {
		inStack.push(num);
	}
	
	public Integer poll() {
		if(outStack.isEmpty()) {
			dumpToOut();
		}
		return outStack.pop();
	}
	
	public void dumpToOut() {
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
	}
	
}
