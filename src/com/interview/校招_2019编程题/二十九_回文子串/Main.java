package com.interview.校招_2019编程题.二十九_回文子串;

import java.util.Scanner;

/**
 * 中心拓展算法
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int result = 0;
		for(int i=0; i<line.length(); i++) {
			result = result + expend(line, i, i) + expend(line,i, i+1);
		}
		System.out.println(result);
	}
	
	public static int expend(String str, int begin, int end) {
		int len = 0;
		while(end<str.length() && begin>=0) {
			if(str.charAt(begin)==str.charAt(end)) {
				len++;
				begin--;
				end++;
				continue;
			}
			break;
		}
		return len;
	}

}
