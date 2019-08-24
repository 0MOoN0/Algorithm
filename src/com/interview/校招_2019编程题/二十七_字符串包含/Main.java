package com.interview.校招_2019编程题.二十七_字符串包含;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] strLine = sc.nextLine().split(" ");
//			String[] split = strLine[0].split(strLine[1]);
			String child, parent;
			if(strLine[1].length() > strLine[0].length()) {
				parent = strLine[1];
				child = strLine[0];
			}else {
				parent = strLine[0];
				child = strLine[1];
			}
	        Pattern p = Pattern.compile( child );
	        Matcher m = p.matcher(parent);
			if(m.find()) {
				System.out.println(1);
				continue;
			}
			System.out.println(0);
		}
		
	}

}
