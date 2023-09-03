package com.剑指offer_第二版.一一_盛最多水的容器;

class Solution {
    // 双指针，寻找最大值，短边的一方移动
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            if (height[left] >= height[right]) {
                max = Math.max(height[right] * (right - left), max);
                right--;
                continue;
            }
            if (height[left] < height[right]) {
                max = Math.max(height[left] * (right - left), max);
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(arr);
        System.out.println(result);
    }

}