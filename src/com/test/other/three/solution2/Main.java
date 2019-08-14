package com.test.other.three.solution2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long result = 0;
		int size = sc.nextInt();
		int [] arr = new int[size];
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		int[] copy = arr.clone();
		Arrays.sort(copy);
		for(int i:copy) {
			set.add(i);
		}
		Iterator<Integer> iterator = set.iterator();
		int i=1;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		while(iterator.hasNext()) {
			map.put(iterator.next(), i);
			i++;
		}
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator2 = keySet.iterator();
		while(iterator2.hasNext()) {
			Integer key = iterator2.next();
			Integer value = map.get(key);
			result = result+(value*100);
		}
		System.out.println(result);
	}

}
