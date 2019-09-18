package com.test.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		List<Integer> a = Arrays.asList(1,2,3);
		List<Integer> b = Arrays.asList(1,2,3);
		System.out.println(a.equals(b));
        String[] strs = {"AA","BB"};  
        Set<String> set2 = new HashSet<String>(Arrays.asList(strs));
        System.out.println(0==-0);
	}

}
