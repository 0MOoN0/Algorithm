package com.interview.��ָoffer.��һ_ջ��ѹ�뵯������;
import java.util.Stack;
// ջ��ѭFILOԭ��
// 1. ���ջ��Ԫ�ز�����popAָ���Ԫ�أ���ͣ��ջ
// 2. ���ջ��Ԫ�ص���popAָ���Ԫ�أ���ջ��popAָ������
// 3. ���pushA�����ָ���Ѿ�ָ��ĩβ������ջ��Ԫ�ز�ΪpopAָ���Ԫ�أ��򷵻�false
// ����ֵΪture��ʱ��ָ��popA��ָ��ָ�����
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // ģ����ջ��ջ
        Stack<Integer> stack = new Stack<Integer>();
        int p=0, q=0; // p q ָ��ֱ�ָ��pushA��popA
        
        while(q != popA.length){
            // ��ջ
            while(stack.isEmpty() || stack.peek() != popA[q]){
                if(p<pushA.length){
                    stack.push(pushA[p++]);
                    continue;
                }
                return false;
            }
            // ջ����popAָ��ָ��������ͬ
            stack.pop();
            q++;
        }
        return true;

        
    }
}