package com.interview.��ָoffer.�ľ�_���ַ���ת������;
// �ݹ�+��·
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // ʹ�ö�·��ֹ�ݹ�
        boolean flag = ((n>0) && (sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}