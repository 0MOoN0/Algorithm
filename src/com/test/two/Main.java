package com.test.two;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
	}

}
