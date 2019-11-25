package com.test.two;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	set.add(2);
    	set.add(3);
    	set.add(5);
    	System.out.println(set.contains(3.0));
//    	System.out.println(3.0f==3);
    }
    

}
