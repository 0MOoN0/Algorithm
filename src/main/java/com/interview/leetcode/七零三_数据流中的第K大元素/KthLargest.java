package com.interview.leetcode.七零三_数据流中的第K大元素;

import java.util.*;
class KthLargest {
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        // 创建一个大小为K的最小堆堆顶元素即为结果
        queue = new PriorityQueue<Integer>(k);
        this.k = k;
        // 用所给的数据初始化
        for(int n: nums)
            add(n);
    }
    
    public int add(int val) {
        // 检查队列是否已满
        if(queue.size()<k){
            // 入队
            queue.offer(val);
        }else if(queue.peek()<val){ // 队列已满，检查元素是否大于堆顶
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
