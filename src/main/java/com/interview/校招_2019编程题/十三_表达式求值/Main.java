package com.interview.校招_2019编程题.十三_表达式求值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		String[] line = reader.readLine().split(" ");
		for(int i=0; i<line.length; i++) {
			int temp = Integer.parseInt(line[i]);
			max = temp+max > temp*max ? temp+max : temp*max;
		}
		System.out.println(max);
	}

}
