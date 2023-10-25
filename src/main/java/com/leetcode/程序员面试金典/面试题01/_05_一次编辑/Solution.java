package com.leetcode.程序员面试金典.面试题01._05_一次编辑;

class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length() - second.length()) >= 2 ){
            return false;
        }
        int p = 0, q = 0;
        boolean change = false;
        while(p < first.length() && q < second.length()){
            if(first.charAt(p) == second.charAt(q)){
                p++;
                q++;
                continue;
            }
            if(change){
                return false;
            }
            if(!change && p < first.length()-1 && first.charAt(p+1) == second.charAt(q)){
                change = true;
                p++;
                continue;
            }
            if(!change && q < second.length()-1 && second.charAt(q+1) == first.charAt(p)){
                change = true;
                q++;
                continue;
            }
            p++;
            q++;
            change = true;
        }
        return change || first.length() == second.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.oneEditAway("palea","palae");
    }

}