package com.leetcode.三四_二分查找;

/**
 * 解题思路：多次二分查找
 *  分成两个二分查找，分别找左边界和右边界
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 找左边界
        int left = findIndex(nums, target, true);
        int right = findIndex(nums, target, false);
        return new int[]{left, right};
    }

    public int findIndex(int [] nums, int target, boolean lower){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] ==  target){
                ans = mid;
                if(lower){
                    // 找左边界，所以要向左逼近
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

}