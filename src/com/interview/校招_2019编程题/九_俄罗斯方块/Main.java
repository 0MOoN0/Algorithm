package com.interview.У��_2019�����.��_����˹����;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		long size = sc.nextInt();
		int []arr = new int[width];
		for(int i=0; i<size; i++) {
			arr[sc.nextInt()-1]+=1;
		}
		Arrays.sort(arr);
		System.out.println(arr[0]);
	}

}
