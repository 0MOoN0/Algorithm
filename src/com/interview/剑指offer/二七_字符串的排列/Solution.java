package com.interview.剑指offer.二七_字符串的排列;

import java.util.ArrayList;
import java.util.TreeSet;
// 字母包括大小写
// 字符可能有重复
public class Solution {
    
    public ArrayList<String> Permutation(String str) {
    	// TreeSet可以根据自然顺序排序
        TreeSet<String> temp = new TreeSet<String>();
        ArrayList<String> result = new ArrayList<String>();
        if(str==null || str.equals("")) return result;
       // 转成字节数组
        char [] cs = str.toCharArray();
        perm(cs, 0, cs.length, temp);
        result.addAll(temp);
        return result;
    }
    
    public void perm(char[] cs, int start, int end, TreeSet<String> result){
        if(start==end){
            result.add(new String(cs));
        }else{
            // 将第一位与其他位交换，剩下的做全排列
            for(int i=start; i<end; i++){
                //if(cs[start]==cs[i] && start!=i) continue;
                // 交换
                swap(cs, i, start);
                // 对剩下的数字内容进行全排列
                perm(cs, start+1, end, result);
                // 回归状态，进行回溯
                swap(cs, i, start);
            }
        }
    }
    
    public void swap(char[] cs, int a, int b){
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }
    
}
