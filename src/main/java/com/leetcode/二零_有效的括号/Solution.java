package com.leetcode.二零_有效的括号;

import java.util.Stack;

/**
 * @author Leon
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
                continue;
            }
            // 闭括号
            if(stack.isEmpty()){
                return false;
            }
            if((chars[i]==')' && stack.pop()!='(') || (chars[i]==']' && stack.pop()!='[') || (chars[i]=='}' && stack.pop()!='{')){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
