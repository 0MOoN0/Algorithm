package com.leetcode.八八_合并两个有序数组;

/**
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 两个数组其中一个不为空
 *
 * @author Leon
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            nums1[length--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n>=0){
            nums1[length--] = nums2[n--];
        }
    }
}
