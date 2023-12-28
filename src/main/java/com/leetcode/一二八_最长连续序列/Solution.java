package com.leetcode.一二八_最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路：
 *  1. 数组是无序的，无法直接使用二分查找。
 *  2. 普通的做法是遍历数组，然后判断每一个数的前驱数和后驱数是否存在。
 *  3. 可以在这个方法的基础上进行改进，使用HashSet存储数组中的数，然后遍历HashSet，如果当前数的前驱数存在，则跳过；
 *      如果当前数的后驱数存在，则将当前数加入结果中。这种方法可以避免重复遍历前驱数的问题。
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nSet = new HashSet<Integer>();
        for(int num : nums){
            nSet.add(num);
        }
        int longestConsecutive = 0;
        // 遍历set，判断是否有前驱数，如果有前驱数则跳过，否则递增遍历
        for(int num : nSet){
            int curLongest = 1;
            if(!nSet.contains(num-1)){
                for(int i=1; nSet.contains(num+i);i++){
                    curLongest++;
                }
            }
            longestConsecutive = Math.max(longestConsecutive, curLongest);
        }
        return longestConsecutive;
    }
}