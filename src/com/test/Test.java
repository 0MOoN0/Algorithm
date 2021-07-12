package com.test;

import com.interview.leetcode.五八_最后一个单词的长度.Solution2;

import java.util.Arrays;

class Test {
    public static void main(String[] args){
        int[] a = new int[]{1,2,3};
        a = new int[a.length+1];
        Arrays.stream(a).forEach(System.out::println);
    }
}
