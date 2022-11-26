package com.test.other.three;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int perYear = 0;
		int perOne = 0;
		long result = 0;
		int size = sc.nextInt();
		for(int i=0;i<size;i++) {
			int year = sc.nextInt();
			if(year>perYear) {
				result = result+(perOne+100);
				perYear = year;
				perOne += 100;
			}else if(year == perYear) {
				result = result+perOne;
				perYear = year;
			}else {
				result = result+100;
				perYear = year;
				perOne = 100;
			}
		}
		System.out.println(result);
	}

}
