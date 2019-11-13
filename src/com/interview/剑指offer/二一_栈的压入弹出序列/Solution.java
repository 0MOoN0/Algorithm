package com.interview.剑指offer.二一_栈的压入弹出序列;
import java.util.Stack;
// 栈遵循FILO原则
// 1. 如果栈顶元素不等于popA指针的元素，则不停入栈
// 2. 如果栈顶元素等于popA指针的元素，出栈，popA指针右移
// 3. 如果pushA数组的指针已经指向末尾，并且栈顶元素不为popA指向的元素，则返回false
// 返回值为ture的时候：指向popA的指针指向最后
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 模拟入栈出栈
        Stack<Integer> stack = new Stack<Integer>();
        int p=0, q=0; // p q 指针分别指向pushA和popA
        
        while(q != popA.length){
            // 入栈
            while(stack.isEmpty() || stack.peek() != popA[q]){
                if(p<pushA.length){
                    stack.push(pushA[p++]);
                    continue;
                }
                return false;
            }
            // 栈顶与popA指针指向内容相同
            stack.pop();
            q++;
        }
        return true;

        
    }
}