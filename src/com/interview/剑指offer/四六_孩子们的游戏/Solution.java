package com.interview.��ָoffer.����_�����ǵ���Ϸ;
// ʹ������ģ�⻷
// 1. ��ֹ������ֻʣ��һ��С����
// 2. �������ݲ�Ϊ��ʱ������Ч��һ��
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        int count = n;
        int index = 0;
        int step = 0;
        int [] cycle = new int[n];
        while(count>0){
            if(index>=n){
                index = index%n;
            }
            // �жϵ�ǰָ���Ƿ���Ч
            // ��Ч��index+1, ����+1
            if(cycle[index] != -1){
                step+=1;
                if(step == m){
                    cycle[index] = -1;
                    count--;
                    // ����step�����㿪ʼ����
                    step = 0;
                }
            }
            // ��Ч��index+1,�ٽ���ѭ��
            index+=1;
        }
        return index-1;
    }
}