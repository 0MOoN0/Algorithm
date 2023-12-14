package com.leetcode.四九_字母异位词分组;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<String, List<String>>();
        for (String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String nStr = new String(cs);
            List<String> strList = resMap.get(nStr);
            if(strList == null){
                strList = new ArrayList<String>();
                resMap.put(nStr, strList);
            }
            strList.add(str);
        }
        return new ArrayList(resMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        solution.groupAnagrams(strs);
    }

}