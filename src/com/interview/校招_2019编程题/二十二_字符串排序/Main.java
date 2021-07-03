package com.interview.校招_2019编程题.二十二_字符串排序;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		// 输入
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<size; i++) {
			String line = reader.readLine();
			line = line.substring(line.length()-6, line.length());
			list.add(Integer.parseInt(line));
		}
		Collections.sort(list);
		list.forEach(System.out::println);
	}

}
