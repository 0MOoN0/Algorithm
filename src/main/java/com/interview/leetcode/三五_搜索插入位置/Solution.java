package com.interview.leetcode.三五_搜索插入位置;

/**
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 使用二分查找,返回左指针，如果找得到目标元素，返回目标元素的值，如果找不到，返回该元素插入位置
 *
 * @author Leon
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {

        int right = nums.length-1;
        int left = 0;
        int mid;
        while(left <= right){
            mid = (right+left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.searchInsert(new int[]{1,3,5,6},2 );
    }
}
