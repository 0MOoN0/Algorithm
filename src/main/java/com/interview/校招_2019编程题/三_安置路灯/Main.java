package com.interview.校招_2019编程题.三_安置路灯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testSize = Integer.parseInt(reader.readLine());
		int count = 0;
		for(int i=0; i<testSize; i++) {
			int size = Integer.parseInt(reader.readLine());
			String line = reader.readLine();
			char[] cs = line.toCharArray();
			for(int j=0; j<cs.length; j++) {
				if(cs[j]=='.') {
					j+=2;
					count++;
				}
			}
			System.out.println(count);
			count=0;
		}
	}
}
