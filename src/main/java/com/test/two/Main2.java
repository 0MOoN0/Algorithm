package com.test.two;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(128, map);
		map.put(129, map);
		map.put(127, map);
		System.out.println(map.containsKey(127));
		System.out.println(map.containsKey(128));
		System.out.println(map.containsKey(129));
		
	}
	
	
}

