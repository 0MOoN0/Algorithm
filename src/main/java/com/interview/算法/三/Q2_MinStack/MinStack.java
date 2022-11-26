package com.interview.算法.三.Q2_MinStack;

import com.interview.算法.三.Q2_stack_queue.Array_To_Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 * 要求：pop、push、getMin操作的时间复杂度都是O(1)。
 * @author Peter
 *
 */
public class MinStack {

	private Array_To_Stack stack;
	private Array_To_Stack minStack;

	public static void main(String[] args) {
		MinStack ms = new MinStack(4);
		ms.push(4);
		System.out.println(ms.getMin());
		ms.push(1);
		System.out.println(ms.getMin());
		ms.push(3);
		System.out.println(ms.getMin());
		ms.push(-1);
		System.out.println(ms.getMin());
		
	}
	
	public MinStack(int size) {
		stack = new Array_To_Stack(size);
		minStack = new Array_To_Stack(size);
	}

	public Integer peek() {
		return stack.peek();
	}

	public void push(int num) {
		stack.push(num);
		if(minStack.isEmpty()) {
			minStack.push(num);
		}else if(minStack.peek()>num) {
			minStack.push(num);
		}else {
			minStack.push(minStack.peek());
		}
	}

	public Integer pop() {
		minStack.pop();
		return stack.pop();
	}
	
	public Integer getMin() {
		return minStack.peek();
	}

}
