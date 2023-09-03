package com.剑指offer_第二版.二一_调整数组顺序使奇数位于偶数前面;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
class Solution {
    public int[] exchange(int[] nums) {
        // 双指针
        int p = 0, q = nums.length - 1;
        while (p < q) {
            if (nums[p] % 2 == 0) {
                int i = nums[q];
                nums[q] = nums[p];
                nums[p] = i;
                q--;
                continue;
            }
            p++;
        }
        return nums;
    }
}