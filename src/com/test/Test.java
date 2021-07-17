package com.test;

import com.interview.leetcode.五八_最后一个单词的长度.Solution2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

class Test {
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{4,5,6};
        System.arraycopy(b,0,a,3,b.length);
        Arrays.stream(a).forEach(System.out::println);
    }
}
