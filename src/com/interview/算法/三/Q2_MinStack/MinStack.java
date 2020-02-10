package com.interview.�㷨.��.Q2_MinStack;

import com.interview.�㷨.��.Q2_stack_queue.Array_To_Stack;

/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ� ��ջ����СԪ�صĲ�����
 * Ҫ��pop��push��getMin������ʱ�临�Ӷȶ���O(1)��
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
		if(minStack.peek()==null) {
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
