package com.interview.网易.three_独立的小易;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int liveingDay = 0;
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int f = scanner.nextInt();
		int d = scanner.nextInt();
		int p = scanner.nextInt();
		
		while(d > 0) {
			if(f > 0) {
				d -= x;
				f--;
				liveingDay++;
				continue;
			}
			d -= (x+p);
			liveingDay++;
			continue;
		}
		if(d <0) {
			liveingDay --;
		}
		System.out.println(liveingDay);
	}

	

}
