package com.leetcode.程序员面试金典.面试题01._06_字符串压缩;

public class Solution {
    public String compressString(String S) {
        if(S.length() <= 2 ){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char [] cs = S.toCharArray();
        sb.append(cs[0]);
        int p = 0, q=sb.length()-1;
        int curCount = 0;
        while(p < S.length()){
            // 如果两个字符相等，p指针移动
            if(cs[p] == sb.charAt(q)){
                curCount++;
                p++;
                continue;
            }
            // 如果不相等
            sb.append(curCount);
            curCount = 0;
            sb.append(cs[p]);
            q=sb.length()-1;

        }
        sb.append(curCount);
        return sb.length()<S.length() ? sb.toString() : S;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String output = solution.compressString("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff");
        System.out.println(output);
    }

}