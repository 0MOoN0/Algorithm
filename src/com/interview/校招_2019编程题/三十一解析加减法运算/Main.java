package com.interview.У��_2019�����.��ʮһ�����Ӽ�������;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int result = 0, pos = 0;
		for(int i=1; i<line.length(); i++) {
			if(line.charAt(i)=='-' || line.charAt(i)=='+') {
				result += Integer.parseInt(line.substring(pos,i));
				pos = i;
			}
		}
		// ���һ���ַ�
		result += Integer.parseInt(line.substring(pos,line.length()));
		System.out.println(result);
	}

}
