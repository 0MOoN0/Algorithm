package com.interview.leetcode.一七一三_得到子序列的最少操作次数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @author Leon
 */
public class Solution {


    public int minOperations(int[] target, int[] arr) {
        int result = target.length + 1;
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        for (int i = 0; i < target.length; i++) {
            set.add(target[i]);
        }
        int i = 0;
        while (set.size() > 0 && i < arr.length) {

        }
        return result;
    }
}
