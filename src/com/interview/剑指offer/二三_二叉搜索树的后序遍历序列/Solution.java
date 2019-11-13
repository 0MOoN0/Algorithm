package com.interview.剑指offer.二三_二叉搜索树的后序遍历序列;

// 1. 后序遍历中，序列末尾为查找树的根
// 2. 根的左子树所有的元素都小于根，根的右子树所有的元素都大于根
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }
    
    public boolean verify(int[] sequence, int begin, int end){
        // 递归结束条件：已经遍历到树的末尾
        if(begin==end){
            return true;
        }
        // 并非末尾
        // 找到比根节点小的元素
        int min = end-1;
        while(min>begin){
            if(sequence[min]<sequence[end]) break;
            min--;
        }
        // 从前开始遍历，查看min里面是否有元素比根节点大的
        for(int i=begin; i<min; i++){
            if(sequence[i] > sequence[end]) return false;
        }
        return verify(sequence, begin, min) && verify(sequence, min+1, end);
    }
}