package com.interview.校招_2018编程题.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		String[] split = reader.readLine().split(" ");
		ArrayList<Long> zs = new ArrayList();
		ArrayList<Long> fs = new ArrayList();
		Long temp = 0l;
		for(int i=0;i<split.length;i++) {
			temp = Long.parseLong(split[i]);
			if(temp>0) {
				zs.add(temp);
			}else {
				fs.add(temp);
			}
		}
		// 对数组排序
		Collections.sort(zs);
		Collections.sort(fs);
		
		// 三正 or 两负一正
		if(zs.size()>=3) {
			if(fs.size() >= 2){
				System.out.println(
						Math.max((zs.get(zs.size()-1) * zs.get(zs.size()-2) * zs.get(zs.size()-3)),(zs.get(zs.size()-1) * fs.get(0) * fs.get(1)))
				);
			}
			System.out.println(zs.get(zs.size()-1) * zs.get(zs.size()-2) * zs.get(zs.size()-3));
		// 两正一负 or 两负一正
		}else if(zs.size() >= 2) {
			if(fs.size() >= 2) {
				System.out.println(
						Math.max(zs.get(zs.size()-1)*fs.get(0)*fs.get(1), zs.get(0)*zs.get(1)*fs.get(fs.size()-1))
						);
			}
			System.out.println(zs.get(0)*zs.get(1)*fs.get(fs.size()-1));
		// 两负一正
		}else if(zs.size()==1) {
			System.out.println(zs.get(0)*fs.get(0)*fs.get(1));
		// 三负
		}else {
			System.out.println(fs.get(0)*fs.get(1)*fs.get(2));
		}
		
	}

}
