package com.interview.У��_2019�����.��ʮ_�ַ���ѹ��;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
		for(int i=0; i<line.length(); i++) {
			char charAt = line.charAt(i);
			Integer val = map.getOrDefault(charAt+"", 0);
			map.put(charAt+"", val+1);
		}
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			System.out.print(entry.getValue()+entry.getKey());
		}
	}

}
