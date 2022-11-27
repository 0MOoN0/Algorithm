package com.leetcode.六六_加一;

import java.util.Arrays;

/**
 * 对数组里的数+1，返回结果数组
 * [9,9,9]+1 = [1,0,0,0]
 * 注意：可能会进位，但因为是加一，所以最多进一位
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 精简版分析：
 * 数组加法存在两种情况，进位或不进位
 * 如果不进位，直接返回即可
 * 如果进位，且最高位为9，则继续进位，直到遍历完数组
 *
 * @author Leon
 */
public class Solution {

    // 精简版
    public int[] plusOne_2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = (digits[i] + 1) % 10;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        // 遍历完数组,走到这一步，说明还要进位
        digits = new int[digits.length + 1];  // 初始化数组元素位0，不再需要其他操作
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean isCarry = true;
        while (isCarry && index >= 0) {
            isCarry = (digits[index] + 1) > 9;
            digits[index] = (digits[index] + 1) % 10;
            index--;
        }
        if (isCarry) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            digits = newArray;
        }
        return digits;
    }
}
