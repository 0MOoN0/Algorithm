package com.interview.leetcode.八八_合并两个有序数组;

import java.util.Arrays;

/**
 * @author Leon
 */
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
