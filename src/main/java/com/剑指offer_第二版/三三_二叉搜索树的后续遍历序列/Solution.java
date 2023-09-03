package com.剑指offer_第二版.三三_二叉搜索树的后续遍历序列;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return sub(postorder, 0, postorder.length-1);
    }

    public boolean sub(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int count = left;
        while(postorder[count] < postorder[right]){
            count++;
        }
        int minerCounter = count;
        while(postorder[count] > postorder[right]){
            count++;
        }
        return count==right && sub(postorder, left, minerCounter-1) && sub(postorder, minerCounter, right-1);
    }
}