package com.interview.剑指offer.五_用两个栈实现队列;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        // 栈1入栈
    	stack1.push(node);
    }
    
    public int pop() {
    	// 检查栈2是否为空
    	if(stack2.isEmpty()) {
    		// dump出栈1
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
}
