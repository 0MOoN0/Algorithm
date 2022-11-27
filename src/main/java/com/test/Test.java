package com.test;

import com.interview.leetcode.一零零_相同的树.TreeNode;

import java.util.*;

class Test {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(256);
        System.out.println(set.contains(1));
        System.out.println(set.contains(256));
    }
}

