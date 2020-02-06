package com.interview.算法.三.Q2_stack_queue;

/**
 * 用数组实现一个固定长度的栈
 * 规定：index初始为0，指向下一个入栈的空间；
 * 假如栈的大小为2，则栈满时index为2，栈空时index为0，因此入栈需要先入栈,index++;出栈需要，--index，再出栈
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
			throw new RuntimeException("栈已满");
		}
		arr[index++] = num;
	}
	
	public Integer pop() {
		if(index==0) {
			throw new RuntimeException("栈已空");
		}
		return arr[--index];
	}
	
}
