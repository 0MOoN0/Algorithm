package com.leetcode.五八_最后一个单词的长度;

/**
 * 在Solution3的基础上改进，手动模拟Trim
 * 思路： Trim + 计算最后一个空格出现的索引，计算出最后一个字符的长度
 *
 * @author Leon
 */
public class Solution4 {

    public int lengthOfLastWord(String s) {
        int left = 0;
        int right = s.length() - 1;
        while ((s.charAt(left) == ' ' || s.charAt(right) == ' ') && left < right) {
            if (s.charAt(left) == ' ') {
                left++;
            }
            if (s.charAt(right) == ' ') {
                right--;
            }
        }
        for (int i = right; i >= left; i--) {
            if (s.charAt(i) == ' ') {
                return right-i;
            }
        }
        return right - left +1;
    }

}
