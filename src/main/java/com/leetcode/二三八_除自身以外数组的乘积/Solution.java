package com.leetcode.二三八_除自身以外数组的乘积;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] sequence = new int[size];
        sequence[0] = nums[0];
        for (int i = 1; i < size; i++) {
            sequence[i] = nums[i] * sequence[i - 1];
        }
        int[] nsequence = new int[size];
        nsequence[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            nsequence[i] = nums[i] * nsequence[i + 1];
        }
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = nsequence[i + 1];
                continue;
            }
            if (i == res.length - 1) {
                res[i] = sequence[i - 1];
                continue;
            }
            res[i] = sequence[i - 1] * sequence[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] res = solution.productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}