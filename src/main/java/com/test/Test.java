package com.test;


import java.util.HashSet;
import java.util.Set;

class Test {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(256);
        System.out.println(set.contains(1));
        System.out.println(set.contains(256));
    }
}

