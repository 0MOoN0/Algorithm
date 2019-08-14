package com.interview.У��_2019�����.one.solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int personSize = sc.nextInt();
		int taskSize = sc.nextInt();
		int [][] arr = new int[taskSize][2];
		for(int i=0;i<taskSize; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		TreeMap map = new TreeMap();
		
		// ���ѶȽ�������
		Arrays.sort(arr, (x,y) -> x[0] - y[0]);
		
		// ��֤�Ѷ�С�ı��겻������Ѷȴ�ı���
		for(int i=1;i<arr.length; i++) {
			arr[i][1] = Math.max(arr[i-1][1], arr[i][1]);
		}
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i][0], arr[i][1]);
		}
		int ablity = 0;
		for(int i=0;i<personSize;i++) {
			ablity = sc.nextInt();
			Object floorKey = map.floorKey(ablity);
			if(floorKey!=null) {
				System.out.println(map.get(floorKey));
			}else {
				System.out.println(0);
			}
		}
	}

}
