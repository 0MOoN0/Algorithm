package com.interview.��ָoffer.����_�ַ����е�һ�����ظ�������;
import java.util.*;
public class Solution {
    
    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
    StringBuffer sb = new StringBuffer();
    //Insert one char from stringstream
    // ��¼������ַ������Լ�ƴ�ɵ��ַ���
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