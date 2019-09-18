package com.test.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3};
		int [] b = new int[] {3,2,1};
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,2,1);
		outerList.add(list1);
		outerList.add(list2);
		List<Integer> list3 = Arrays.asList(3,2,1);
		System.out.println(list2.containsAll(list3));
		outerList.forEach(list->
		{
			if(list.containsAll(list3)) {
				outerList.add(list3);
			}
		}
		);
		System.out.println(outerList.containsAll(list3));
		HashSet<Integer> set = new HashSet<Integer>();
	}

}
