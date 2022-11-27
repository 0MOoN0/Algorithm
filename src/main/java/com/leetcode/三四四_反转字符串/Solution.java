package com.leetcode.三四四_反转字符串;
/**
 * 使用双重指针的思想，需要一个字符的空间开销
 * 一个指针指向数组的头，一个指针指向数组的尾，交换两者内容，再移动，直到左指针不小于右指针
 * @author Peter
 *
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
            left++;
            right--;
        }
    }

}
