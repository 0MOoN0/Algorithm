package com.interview.����.six_ʱ��;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		String result [] = new String[size];
		String split[] = new String[3];
		int hour=0, min=0, sec=0;
		for (int i = 0; i < size; i++) {
			result[i] = sc.nextLine();
			split = result[i].split(":");
			hour = Integer.parseInt(split[0]);
			min = Integer.parseInt(split[1]);
			sec = Integer.parseInt(split[2]);
			// ʱ
			if(hour>23) {
				// �ж�ʮλ��
//				if(hour/10 > 2) {
					hour = hour%10;
					split[0] = "0"+hour;
//				}
			}
			// ��
			if(min > 59) {
				min = min%10;
				split[1] = "0"+min;
			}
			// ��
			if(sec > 59) {
				sec = sec%10;
				split[2] = "0"+ sec;
			}
			result[i] = split[0]+":"+split[1]+":"+split[2];
			System.out.println(result[i]);
		}
	}
}
