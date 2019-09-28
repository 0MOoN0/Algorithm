package com.interview.leetcode.六九_x的平方根;

// 二分法，因为只求整数，所以精确到二位小数即可
//WA
class Solution {
    public int mySqrt(int x) {
        // 判断小数位是否大于零
        // 二分，取出中点
        // 比较中点平方大小
        // 大于，选取左到中点的距离再二分
        // 小于，选取中间与右边的距离再二分
        return divide(0, new Double(x), x, (double)x/2 );   
        
    }

    public int divide(double begin, double end, int target, Double middle){
        String[] middleStr = (middle+"").split("\\.");
        if(Math.pow(middle,2)==target || middleStr.length>=2 && middleStr[1].length()>=2){
            // 取整数，返回
            return middle.intValue();
        }
        // 二分，取中点
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