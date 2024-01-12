package com.leetcode.二零八五_统计出现过一次的公共字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<words1.length; i++){
            int times = map.getOrDefault(words1[i], 0);
            map.put(words1[i], times+1);
        }
        for(int i=0;i<words2.length;i++){
            int times = map.getOrDefault(words2[i], 0);
            map.put(words2[i], times+1);
        }
        int res = 0;
        return res;
    }
}