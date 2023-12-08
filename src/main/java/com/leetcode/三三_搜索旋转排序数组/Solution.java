package com.leetcode.三三_搜索旋转排序数组;

/**
 *解题思路，二分查找，数据本身是有序并且不重复的，因此在旋转后可以分成两个区间，一个是递增区间，一个是无序区间。
 *  使用二分查找的思路，如果当前的数不是在递增区间就是在无序区间。
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断升序部分在左边
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                continue;
                // 升序部分在右边
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3};
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Solution solution = new Solution();
        solution.search(nums, 0);
    }

}