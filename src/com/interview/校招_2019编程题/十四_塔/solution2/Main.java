package com.interview.校招_2019编程题.十四_塔.solution2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 使用Collections.max和Collections.min函数
 * @author Peter
 *
 */

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		String[] line2 = reader.readLine().split(" ");
		int tower = Integer.parseInt(line[0]);
		int times = Integer.parseInt(line[1]);
		ArrayList<Integer> towers = new ArrayList<Integer>(tower);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<line2.length; i++) {
			towers.add(Integer.parseInt(line2[i]));
		}
		for(int i=0; i<times; i++) {
			Integer max = Collections.max(towers);
			Integer min = Collections.min(towers);
			if(max - min<2) break;
			int maxIndex = towers.indexOf(max);
			int minIndex = towers.indexOf(min);
			towers.set(maxIndex, --max);
			towers.set(minIndex, ++min);
			result.add(maxIndex+1);
			result.add(minIndex+1);
		}
		// 输出
		System.out.println(Collections.max(towers) - Collections.min(towers) +" "+ (result.size()/2));
		for(int i=0; i<result.size(); i+=2) {
			System.out.println(result.get(i)+" "+result.get(i+1));
		}
	}

}
