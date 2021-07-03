package com.interview.leetcode.二二_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右括号需要满足的条件:
 * 1. 左右括号的总数量相等
 * 2。递归时：左括号的数量>=右括号数量
 * 3. 左括号数量不可大于n
 */
class Solution {
    // 构建结果List
    List<String> result = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        gen(0, 0, n, "");
        return result;
    }

    public void gen(int left, int right, int n, String str){
        // 递归终止条件
        if(left == n && right == n){
            result.add(str);
            return ;
        }

        // 添加左括号的情况
        if(left < n){ // left 小于n 括号可以随便加
            gen(left+1, right, n, str+"(");
        }

        // 添加右括号的情况
        // right小于n并且右括号数量比左括号少时，可以添加右括号与左括号配对
        if(right<n && right<left){ 
            gen(left, right+1, n, str+")");
        }
    }
}
