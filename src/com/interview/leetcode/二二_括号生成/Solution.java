package com.interview.leetcode.����_��������;

import java.util.ArrayList;
import java.util.List;

/**
 * ����������Ҫ���������:
 * 1. �������ŵ����������
 * 2���ݹ�ʱ�������ŵ�����>=����������
 * 3. �������������ɴ���n
 */
class Solution {
    // �������List
    List<String> result = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        gen(0, 0, n, "");
        return result;
    }

    public void gen(int left, int right, int n, String str){
        // �ݹ���ֹ����
        if(left == n && right == n){
            result.add(str);
            return ;
        }

        // ��������ŵ����
        if(left < n){ // left С��n ���ſ�������
            gen(left+1, right, n, str+"(");
        }

        // ��������ŵ����
        // rightС��n������������������������ʱ��������������������������
        if(right<n && right<left){ 
            gen(left, right+1, n, str+")");
        }
    }
}