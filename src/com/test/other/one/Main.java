package com.test.other.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int alertSize = sc.nextInt();
		int alert[][] = new int[alertSize][2];
		for(int i=0; i<alertSize; i++) {
			alert[i][0] = sc.nextInt();
			alert[i][1] = sc.nextInt();
		}
		// 排序
		Arrays.sort(alert, (x, y )->{
			if(x[0]-y[0]<0) {
				return -1;
			}else if(x[0]-y[0]>0) {
				return 1;
			}else {
				return x[1]-y[1];
			}
		});
		// 路程0<=x<=100
		int x = sc.nextInt();
		// 上课时间
		int hour = sc.nextInt();
		int min = sc.nextInt();
		if(min - x <0) {
			int des = min-x;
			if(hour==0) {
				hour=24+(des/60);
			}else {
				hour = hour+(des / 60);
			}
			min = 60+(des % 60);
		}else {
			min = min-x;
		}
		int resultHour = 0;
		int resultMin = 0;
		for(int i=alert.length-1; 0<=i ;i--) {
			// 时钟相等或小于
			if(alert[i][0]<=hour) {
				//分钟相等或小于
				if(alert[i][1]<=min) {
					resultHour = alert[i][0];
					resultMin = alert[i][1];
					break;
				}
			}
		}
		System.out.println(resultHour +" "+ resultMin);
	}

}
