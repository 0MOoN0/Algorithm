package com.interview.�ֽ�����.one_���ӳ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		ArrayList<char []> arr = new ArrayList(size);
		LinkedHashMap<Object, Integer> map = new LinkedHashMap();
		char [] line ;
		for(int i=0;i<arr.size(); i++) {
			line = reader.readLine().toCharArray();
			arr.add(line);
			// ����Ȩֵ
			for(int j=0; j<line.length; j++) {
				if(map.containsKey(line[i])) {
					map.put(line[j], map.get(line[j]) + j+1);
				}else {
					map.put(line[j], j+1);
				}
			}
		}
		
	}

}
