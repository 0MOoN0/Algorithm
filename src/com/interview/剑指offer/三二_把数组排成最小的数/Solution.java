package com.interview.��ָoffer.����_�������ų���С����;
import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String [] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strs[i] = numbers[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>(){
            // "3"<"31" ���� "331">"313"
            public int compare(String s1, String s2){
                String a = s1+s2;
                String b = s2+s1;
                // ���a>b�����s1��s2��˳��
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