package com.leetcode.一一五四_一年中的第几天;

class Solution {
    public int dayOfYear(String date) {
        int res = 0;
        int[] dayArr = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dateArr = date.split("-");
        int month = Integer.parseInt(dateArr[1]);
        for(int i=0;i<month;i++){
            res += dayArr[i];
        }
        // 加上现有天数
        res += Integer.parseInt(dateArr[2]);
        // 判断闰年
        int year = Integer.parseInt(dateArr[0]);
        if((year % 4 ==0 && year %100 != 0) || (year %400 ==0)){
            res+=1;
        }
        return res;
    }
}