package com.程序员面试金典_第六版.面试题_01_05.一次编辑;

/**
 * 思路：
 * 1. 保证第一个字符串的长度小于或等于第二个字符串的长度
 * 2. 分情况讨论：
 *      2.1 如果两个字符串长度相等，只能允许一个字符不相等
 *      2.3 如果两个字符串长度不相等，允许长字符串跳过一个字符
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        // 获取字符串长度，并使第一个字符串长度小于或等于第二个字符串
        int lf = first.length();
        int ls = second.length();
        int dis = Math.abs(lf - ls);
        if (dis > 1){
            return false;
        }
        if (lf > ls){
            return oneEditAway(second, first);
        }
        // 分情况讨论
        // 如果两个字符串长度相等，两个字符串只能允许一个字符不相等
        if (lf == ls){
            int count = 0;
            for(int i= 0;i<lf; i++){
                if((first.charAt(i) != second.charAt(i)) && ++count > 1){
                    return false;
                }
            }
            return true;
        }
        // 如果两个字符串长度不相等，长字符串可以跳过一个字符的内容
        int i=0, pos=0;
        while(i<lf){
            if((first.charAt(i) != second.charAt(i + pos))){
                if (++pos > 1){
                    return false;
                }
                continue;
            }
            ++i;
        }
        return true;
    }
}