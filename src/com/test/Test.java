package com.test;

import com.interview.leetcode.五八_最后一个单词的长度.Solution2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

class Test {
    public static void main(String[] args){
        LinkedHashSet hashSet = new LinkedHashSet<Integer>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(7);
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
