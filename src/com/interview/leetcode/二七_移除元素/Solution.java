package com.interview.leetcode.二七_移除元素;

/**
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * 不使用额外数组空间，而且不需要考虑数组的顺序
 * 使用双指针，前后指针，前指针寻找val，后指针将非val替换到val
 * 右指针即为非val元素的个数
 * 1. 右指针遇到val，右指针--；
 * 2. 左指针遇到val，与右指针交换，左右指针++;
 * 3. 右指针没有遇到val，左指针没有遇到val，左指针++；
 * 边界：
 * 左右指针相遇，仍符合上述情况
 * [1] 0 预期return 1
 * [0] 0 预期return 0
 *
 * @author Leon
 */
public class Solution {


    // 简洁写法，提高代码可读性
    public int removeElement_Simple(int[] nums, int val){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left]!=val){
                left++;
            }else if (nums[right] != val){
                nums[left++] = nums[right--];
            }else{
                right--;
            }
        }
        return left;
    }

    public int removeElement(int[] nums, int val) {
        if (nums != null && nums.length == 0) return 0;
        int lastIndex = nums.length - 1;
        int frontIndex = 0;
        int count = 0;
        while(frontIndex <= lastIndex){
            if(nums[frontIndex] == val && nums[lastIndex] != val){  // 后面的元素往前移
                count++;
                nums[frontIndex] = nums[lastIndex];
                frontIndex++;
                lastIndex--;
                continue;
            }
            if(nums[lastIndex] == val){
                count++;
                lastIndex--;
            }
            if (nums[frontIndex] != val){
                frontIndex++;
            }
        }
        return nums.length - count;
    }
}
