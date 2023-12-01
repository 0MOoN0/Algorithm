package com.leetcode.一七_电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS
 */
class Solution {

    public Map<Character, String> nums = new HashMap<Character, String>();

    public List<String> result = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return result;
        }
        nums.put('2',"abc");
        nums.put('3',"def");
        nums.put('4',"ghi");
        nums.put('5',"jkl");
        nums.put('6',"mno");
        nums.put('7',"pqrs");
        nums.put('8',"tuv");
        nums.put('9',"wxyz");
        fill(digits, 0, new StringBuilder());
        return result;
    }

    public void fill(String digits,int index, StringBuilder sb){
        if(digits.length() <= index){
            result.add(sb.toString());
            return;
        }
        String letter = nums.get(digits.charAt(index));
        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            fill(digits, index+1, sb);
            sb.setLength(sb.length()-1);
        }
    }

}