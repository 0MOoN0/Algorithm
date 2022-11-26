package com.interview.剑指offer.二八_数组中出现次数超过一半的数字;

// 1.数字在数组中出现的次数超过数组长度的一半，因此符合条件的数字只能有一个
// 2.1.排序
// 2.2.找出出现次数最多的那个数，并记录
// 2.3.判断该数出现的次数是否超过了数组长度的一半
import java.util.*;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int [][] record = new int[1][2];
        int size = array.length;
        int countTemp = 1;
        for(int i=0; i<array.length; i++){
            if(i == (size-1)){
                // countTemp++;
                record[0][0] = record[0][1]>countTemp ? record[0][0] : array[i];
                record[0][1] = record[0][1]>countTemp ? record[0][1] : countTemp;
                break;
            }
            if(array[i]==array[i+1]){
                countTemp++;
            }else{
                // 比较当前值出现过的次数
                record[0][0] = record[0][1]>countTemp ? record[0][0] : array[i];
                record[0][1] = record[0][1]>countTemp ? record[0][1] : countTemp;
                // 重置计数器
                countTemp=1;
            }
        }
        return record[0][1]>=((size/2)+1) ? record[0][0] : 0;
    }
}
