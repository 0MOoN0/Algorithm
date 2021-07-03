package com.interview.字节跳动.two_用户喜好;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int userSize = sc.nextInt();
		int [] arr = new int[userSize+1];
//		int like = sc.nextInt();
		for(int i=1; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int range = sc.nextInt();
		int result = 0;
		for(int j=0; j<range; j++) {
			int rangeBegin = sc.nextInt();
			int rangeEnd = sc.nextInt();
			int target = sc.nextInt();
			for(; rangeBegin<=rangeEnd; rangeBegin++) {
				if(arr[rangeBegin]==target) {
					result++;
				}
			}
			System.out.println(result);
			result = 0;
		}
	}

}
