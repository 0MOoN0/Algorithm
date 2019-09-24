package com.interview.leetcode.��һ_N�ʺ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N�ʺ�����
 * �ʺ�Ĺ�����Χ����б����б��ͬ��
 * ��������Ϊһ�������ᣬ��б����бΪһ��б��
 *   ���� y=kx + c��������� c��ֵ��������k��ֵ����Ϊ-1��1����k=1ʱ��ʾ��б��k=-1ʱ����ʾ��б
 *   ��б��c = y+x;
 *   ��б: c = y-x
 */
class Solution {

    // ��������set�����ڴ����б����б��cֵ
    Set<Integer> left = new HashSet<Integer>();
    Set<Integer> right = new HashSet<Integer>();
    // ����һ�������
    List<List<String>> result = new ArrayList<List<String>>();
    // ����һ�����飬��ʾ�ʺ�İڷ�λ��
    int [] queues;
    public List<List<String>> solveNQueens(int n) {
        // ��ʼ���ʺ�����
        queues = new int [n];
        Arrays.fill(queues,-1);
        DFS(0, n);
        return result;
    }

    // DFS����
    public void DFS(int queue, int n){
        // �����ݹ�
        if(queue >= n){
            // ���������������ݹ�
            result.add(printQueue(n));
            return ;
        }
        // �������ܴ��ڵİڷ�λ��
        for(int i=0; i<n; i++){
            // �����ǰλ�ÿ��԰ڷ�
            if(vaild(queue, i)){
                // �ڷŻʺ󣬸�����б�ߺ���б�ߣ�������һ��ѭ��
                left.add(queue+i);
                right.add(queue-i);
                queues[queue] = i;

                DFS(queue+1, n);

                // �Ƴ�������������һ��λ�ò���
                left.remove(queue+i);
                right.remove(queue-i);
                queues[queue] = -1;
            }
        }
    }

    public boolean vaild(int queue, int i){
        if(left.contains(queue+i) || right.contains(queue-i)){
            return false;
        }
        for(int j=0; j<queues.length; j++){
            if(queues[j] == i){
                return false;
            }else if(queues[j]==-1){
                return true;
            }
        }
        return true;
    }

    public List<String> printQueue(int n){
        List<String> list = new ArrayList<String>(n);
        // ���ַ�
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            sb.append(".");
        }
        // ����queues
        for(int i=0; i<queues.length; i++){
            // ��䡰��������
            sb.setCharAt(queues[i],'Q');
            list.add(sb.toString());
            sb.setCharAt(queues[i],'.');
        }
        return list;
    }

}