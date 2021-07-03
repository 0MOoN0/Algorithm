package com.interview.网易.sevne_会话列表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		LinkedHashSet[] set = new LinkedHashSet[size];
		int sessionSize = 0;
		for(int i=0; i<size; i++) {
			sessionSize = Integer.parseInt(reader.readLine());
			String session = reader.readLine();
			String[] split = session.split(" ");
			set[i] = new LinkedHashSet();
			for(int j=split.length-1; 0<=j; j--) {
				set[i].add(split[j]);
			}
		}
		for(int i=0; i<set.length; i++) {
			set[i].stream().forEach(x -> System.out.print(x+" "));
			System.out.println();
		}
	}
}
