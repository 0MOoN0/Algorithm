package com.leetcode.二一五_数组中的第K个最大元素;

/**
 * 寻找第k大元素，有两个前提条件，第一点：用例有重复数据并且无序，第二点：不需要去重，实际上要求的是数组排序后的倒数第k个元素
 * 解题思路：
 *      首先，题目实际要求的是排序后倒数第K个元素，也就是排序后的顺序第length-k个元素。
 *      假设要求的元素位置为 n=nums.length-k
 *      利用快排+分治的思想，不断往n的位置逼近。
 *          第一次快排后，数组分为三个区域，小于nums[n]，等于nums[n]，大于nums[n];
 *          1. 假如n在数组中的位置落在等于nums[n]区域，后面无论如何排序，等于nums[n]的这个区域都不会再发生变化，说明n就是我们要找的元素，直接返回nums[n]即可。
 *          2. 假如n在数据中的位置落在小于区域或大于区域，需要继续寻找，此时包含边界内的整个小于区域或大于区域都是无序的。
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return partition(nums, 0, n-1, n-k);
    }

    public int partition(int[] nums, int l, int r, int k){
        if(l==r){
            return nums[k];
        }
        int left = l;
        int right = r;
        int less = l-1;
        int more = r+1;
        int num = nums[k];
        // 对数据进行归类
        while(l<more){
            if(nums[l] < num){
                swap(nums, ++less, l++);
            }else if(nums[l] > num){
                swap(nums, --more, l);
            }else{
                l++;
            }
        }
        if(k>=more){
            return partition(nums, more, right, k);
        }else if(k<=less){
            return partition(nums, left, less, k);
        }
        return nums[k];
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
         Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }

}