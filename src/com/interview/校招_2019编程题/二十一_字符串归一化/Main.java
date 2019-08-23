package com.interview.校招_2019编程题.二十一_字符串归一化;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] cs = reader.readLine().toCharArray();
//		int [][] arr = new int[26][2];
		TreeMap<String,Integer> map = new TreeMap<String, Integer>();
		for(int i=0; i<cs.length; i++) {
			map.put(cs[i]+"", map.getOrDefault(cs[i]+"", 0)+1);
		}
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			System.out.print(entry.getKey()+entry.getValue());
		}
		
		
	}

}
