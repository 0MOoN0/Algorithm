package com.leetcode.一六二九_按键持续时间最长的键;

/**
 * HashMap
 *
 * @author Leon
 */
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTimes = releaseTimes[0];
        char result = keysPressed.charAt(0);
        // 遍历数组
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff_time = releaseTimes[i] - releaseTimes[i - 1];
            if (diff_time > maxTimes || (diff_time == maxTimes && keysPressed.charAt(i) > result)) {
                maxTimes = diff_time;
                result = keysPressed.charAt(i);
            }
        }
        return result;
    }
}
