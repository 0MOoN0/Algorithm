package com.interview.��ָoffer.����_������ֻ����һ�ε�����;

//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        int flag = 0;
        for(int i=0; i<array.length; i++){
            // ���һλ
            if(i == array.length-1){
                num2[0] = array[i];
                break;
            }
            // ������
            if(array[i]==array[i+1]){
                // i����λ
                i++;
                continue;
            }
            // ��������
            if(flag==0){
                num1[0] = array[i];
                flag = 1;
            }else{
                num2[0] = array[i];
                break;
            }
        }
    }
}