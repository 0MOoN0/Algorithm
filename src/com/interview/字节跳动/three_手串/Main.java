package com.interview.字节跳动.three_手串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int space = sc.nextInt();
		int colorSize = sc.nextInt();
		int result = 0;
		HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<Integer,ArrayList<Integer>>(colorSize);
		for(int i=1; i<=size;i++) {
			int stringSize = sc.nextInt();
			for(int j=1; j<=stringSize; j++) {
				int colorIndex = sc.nextInt();
				ArrayList<Integer> color = hashMap.getOrDefault(colorIndex, new ArrayList<Integer>());
				if(color.size()==0) {
					color.add(0);
				}
				color.add(i);
				hashMap.put(colorIndex, color);
			}
		}
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			ArrayList<Integer> arrayList = hashMap.get(key);
			Collections.sort(arrayList);
			for(int i=2; i<arrayList.size(); i++) {
				if(i==arrayList.size()-1) {
					// 往前比较
					if(arrayList.get(i)-arrayList.get(i-1) < space) {
						result++;
						break;
					}
					// 往后比较
					int index = (arrayList.get(i)+space)%size;
					for(int j=1; j<arrayList.size()-1;j++) {
						if(arrayList.get(j)<index) {
							result++;
							break;
						}else if(arrayList.get(j)>index) {
							break;
						}
					}
				}else {
					if(arrayList.get(i)-arrayList.get(i-1) < space) {
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
		
	}

}
