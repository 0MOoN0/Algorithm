package com.interview.��ָoffer.����_��1��n�ĺ�_�ݹ�Ӷ�·;
// �ݹ�+��·
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // ʹ�ö�·��ֹ�ݹ�
        boolean flag = ((n>0) && (sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}