package com.interview.У��_2019�����.��_��·��ţţ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		char[] cs = reader.readLine().toCharArray();
		int result = 0;
		for(int i=0; i<cs.length; i++) {
			if(cs[i]=='L') {
				result--;
			}else {
				result++;
			}
		}
		result = result%4;
		if(result==-1 || result==3) {
			System.out.println("W");
		}else if(result == -2 || result ==2) {
			System.out.println("S");
		}else if(result ==1 || result==-3) {
			System.out.println("E");
		}else if(result ==0) {
			System.out.println("N");
		}
	}
}
