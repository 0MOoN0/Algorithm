package com.interview.剑指offer.五四_字符流中第一个不重复的数字;
import java.util.*;
public class Solution {
    
    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
    StringBuffer sb = new StringBuffer();
    //Insert one char from stringstream
    // 记录插入的字符次数以及拼成的字符串
    public void Insert(char ch)
    {
        int i = map.getOrDefault(ch, 0);
        map.put(ch, i+1);
        sb.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0; i<sb.length(); i++){
            if(map.get(sb.charAt(i)) == 1){
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
