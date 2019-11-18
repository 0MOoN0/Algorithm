package com.interview.��ָoffer.����_�ַ���������;

import java.util.ArrayList;
import java.util.TreeSet;
// ��ĸ������Сд
// �ַ��������ظ�
public class Solution {
    
    public ArrayList<String> Permutation(String str) {
    	// TreeSet���Ը�����Ȼ˳������
        TreeSet<String> temp = new TreeSet<String>();
        ArrayList<String> result = new ArrayList<String>();
        if(str==null || str.equals("")) return result;
       // ת���ֽ�����
        char [] cs = str.toCharArray();
        perm(cs, 0, cs.length, temp);
        result.addAll(temp);
        return result;
    }
    
    public void perm(char[] cs, int start, int end, TreeSet<String> result){
        if(start==end){
            result.add(new String(cs));
        }else{
            // ����һλ������λ������ʣ�µ���ȫ����
            for(int i=start; i<end; i++){
                //if(cs[start]==cs[i] && start!=i) continue;
                // ����
                swap(cs, i, start);
                // ��ʣ�µ��������ݽ���ȫ����
                perm(cs, start+1, end, result);
                // �ع�״̬�����л���
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