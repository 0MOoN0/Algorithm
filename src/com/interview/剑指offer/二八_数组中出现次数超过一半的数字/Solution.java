package com.interview.��ָoffer.����_�����г��ִ�������һ�������;

// 1.�����������г��ֵĴ����������鳤�ȵ�һ�룬��˷�������������ֻ����һ��
// 2.1.����
// 2.2.�ҳ����ִ��������Ǹ���������¼
// 2.3.�жϸ������ֵĴ����Ƿ񳬹������鳤�ȵ�һ��
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
                // �Ƚϵ�ǰֵ���ֹ��Ĵ���
                record[0][0] = record[0][1]>countTemp ? record[0][0] : array[i];
                record[0][1] = record[0][1]>countTemp ? record[0][1] : countTemp;
                // ���ü�����
                countTemp=1;
            }
        }
        return record[0][1]>=((size/2)+1) ? record[0][0] : 0;
    }
}