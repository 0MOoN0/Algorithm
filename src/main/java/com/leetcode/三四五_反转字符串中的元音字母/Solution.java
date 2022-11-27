package com.leetcode.三四五_反转字符串中的元音字母;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Leon
 */
public class Solution {

    public String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer(s);
        int right = sb.length()-1;
        int left = 0;
        HashSet<Character> yy = new HashSet<Character>();
        Collections.addAll(yy,'a','e','i','o','u');
        while(left<right){
            if(sb.charAt(left) == sb.charAt(right)){
                left++;
                right--;
                continue;
            }
            if(yy.contains(sb.charAt(left)) && yy.contains(sb.charAt(right))){
                char temp = sb.charAt(left);
                sb.replace(left,left+1,sb.charAt(right)+"");
                sb.replace(right,right+1,temp+"");
                left++;
                right--;
                continue;
            }
            left++;
            right--;
        }
        return sb.toString();
    }
}
