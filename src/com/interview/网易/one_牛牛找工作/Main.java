package com.interview.����.one_ţţ�ҹ���;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int messionNum = scanner.nextInt();
		int peopleNum = scanner.nextInt();
		int[][] sessionDetail = new int[messionNum][2];
		for(int i=0;i<messionNum;i++) {
			sessionDetail[i][0] = scanner.nextInt();
			sessionDetail[i][1] = scanner.nextInt();
		}
		

	}

}
