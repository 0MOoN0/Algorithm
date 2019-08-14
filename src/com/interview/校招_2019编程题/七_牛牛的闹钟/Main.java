package com.interview.У��_2019�����.��_ţţ������;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int alerts[] = new int[size];
		for(int i=0; i<size; i++) {
			int hour = sc.nextInt();
			int min = sc.nextInt();
			alerts[i] = 60*hour+min;
		}
		int time= sc.nextInt();
		int hour = sc.nextInt();
		int min = sc.nextInt();
		Arrays.sort(alerts);
		time = Arrays.binarySearch(alerts, hour*60+min-time);
		if(time<0) {
			time = -(time+2);
		}
		System.out.println(alerts[time]/60+" "+alerts[time]%60);
	}

}
