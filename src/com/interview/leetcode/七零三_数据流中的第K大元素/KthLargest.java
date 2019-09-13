package com.interview.leetcode.������_�������еĵ�K��Ԫ��;

import java.util.*;
class KthLargest {
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        // ����һ����СΪK����С�ѶѶ�Ԫ�ؼ�Ϊ���
        queue = new PriorityQueue<Integer>(k);
        this.k = k;
        // �����������ݳ�ʼ��
        for(int n: nums)
            add(n);
    }
    
    public int add(int val) {
        // �������Ƿ�����
        if(queue.size()<k){
            // ���
            queue.offer(val);
        }else if(queue.peek()<val){ // �������������Ԫ���Ƿ���ڶѶ�
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();  
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */