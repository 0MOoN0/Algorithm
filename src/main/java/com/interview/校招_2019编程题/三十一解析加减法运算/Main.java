package com.interview.校招_2019编程题.三十一解析加减法运算;

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
		// 最后一个字符
		result += Integer.parseInt(line.substring(pos,line.length()));
		System.out.println(result);
	}

}
