package com.interview.��ָoffer.����_���������������;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        int sum = 0;
        for(int i=0; i<array.length; i++){
            if(sum+array[i] > array[i]){ // ������뵱ǰֵ�ȵ�ǰֵ��������뵱ǰֵ
                sum+=array[i];
            }else{
                sum = array[i];  // ������뵱ǰֵ�Ľ���ȵ�ǰֵ��С����ֱ��ʹ�õ�ǰֵ
            }
            result = sum>result ? sum : result;
        }
        return result;
    }
}