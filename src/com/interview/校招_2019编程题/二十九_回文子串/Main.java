package com.interview.У��_2019�����.��ʮ��_�����Ӵ�;

import java.util.Scanner;

/**
 * ������չ�㷨
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
