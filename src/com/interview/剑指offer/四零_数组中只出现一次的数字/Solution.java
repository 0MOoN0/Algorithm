package com.interview.剑指offer.四零_数组中只出现一次的数字;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        int flag = 0;
        for(int i=0; i<array.length; i++){
            // 最后一位
            if(i == array.length-1){
                num2[0] = array[i];
                break;
            }
            // 如果相等
            if(array[i]==array[i+1]){
                // i跳两位
                i++;
                continue;
            }
            // 如果不相等
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