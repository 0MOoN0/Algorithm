package com.interview.剑指offer.三二_把数组排成最小的数;
import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String [] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strs[i] = numbers[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>(){
            // "3"<"31" 但是 "331">"313"
            public int compare(String s1, String s2){
                String a = s1+s2;
                String b = s2+s1;
                // 如果a>b则调换s1和s2的顺序
                return a.compareTo(b);
            }
        });
        StringBuffer result = new StringBuffer();
        for(String str : strs){
            result.append(str);
        }
        return result.toString();
    }
}
