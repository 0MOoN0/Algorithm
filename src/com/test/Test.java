package com.test;

import com.interview.leetcode.一零零_相同的树.TreeNode;
import com.interview.leetcode.五八_最后一个单词的长度.Solution2;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Stream;

class Test {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<Integer>();
        Integer i = new Integer(1);
        queue.add(i);
        queue.add(i);
        queue.stream().forEach(System.out::println);
    }
}