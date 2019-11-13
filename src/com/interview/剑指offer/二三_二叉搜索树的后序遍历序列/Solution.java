package com.interview.��ָoffer.����_�����������ĺ����������;

// 1. ��������У�����ĩβΪ�������ĸ�
// 2. �������������е�Ԫ�ض�С�ڸ����������������е�Ԫ�ض����ڸ�
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }
    
    public boolean verify(int[] sequence, int begin, int end){
        // �ݹ�����������Ѿ�����������ĩβ
        if(begin==end){
            return true;
        }
        // ����ĩβ
        // �ҵ��ȸ��ڵ�С��Ԫ��
        int min = end-1;
        while(min>begin){
            if(sequence[min]<sequence[end]) break;
            min--;
        }
        // ��ǰ��ʼ�������鿴min�����Ƿ���Ԫ�رȸ��ڵ���
        for(int i=begin; i<min; i++){
            if(sequence[i] > sequence[end]) return false;
        }
        return verify(sequence, begin, min) && verify(sequence, min+1, end);
    }
}