package com.interview.leetcode.����_x��ƽ����;

// ���ַ�����Ϊֻ�����������Ծ�ȷ����λС������
//WA
class Solution {
    public int mySqrt(int x) {
        // �ж�С��λ�Ƿ������
        // ���֣�ȡ���е�
        // �Ƚ��е�ƽ����С
        // ���ڣ�ѡȡ���е�ľ����ٶ���
        // С�ڣ�ѡȡ�м����ұߵľ����ٶ���
        return divide(0, new Double(x), x, (double)x/2 );   
        
    }

    public int divide(double begin, double end, int target, Double middle){
        String[] middleStr = (middle+"").split("\\.");
        if(Math.pow(middle,2)==target || middleStr.length>=2 && middleStr[1].length()>=2){
            // ȡ����������
            return middle.intValue();
        }
        // ���֣�ȡ�е�
        middle = (begin+end) / 2;
        if(Math.pow(middle,2) > target){
            return divide(begin, middle, target, middle);
        }else if(Math.pow(middle,2) == target){
            return middle.intValue();
        }else{
            return divide(middle, end, target, middle);
        }
    }

}