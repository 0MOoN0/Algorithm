package com.interview.校招_2019编程题.十_瞌睡.solution3_记忆化优化_ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int classSize = Integer.parseInt(line[0]);
		int qx = Integer.parseInt(line[1]);
		int [][] split = new int[classSize][2];
		int [] sleepPoint = new int[classSize];
		int sleep = 0;
		line = reader.readLine().split(" ");
		for(int i=0; i<classSize; i++) {
			split[i][0] = Integer.parseInt(line[i]);
		}
		line = reader.readLine().split(" ");
		for(int i=0; i<classSize; i++) {
			split[i][1] = Integer.parseInt(line[i]);
			// 计算睡眠时的分数
			if(split[i][1]==0) {
				sleep += split[i][0];
			}
			sleepPoint[i] += sleep;
		}
		// 再次遍历数组
		int wakePoint = 0;
		long max = 0;
		for(int i=0; i<classSize; i++) {
			if(split[i][1]==1) {
				wakePoint += split[i][0];
			}else {
				int j = i+qx-1;
				int wakeVal = 0;
				if(j>=classSize) {
					wakeVal = i>0 ? sleepPoint[classSize-1]-sleepPoint[i-1] : sleepPoint[classSize-1];
				}else {
					wakeVal = i>0 ? sleepPoint[j]-sleepPoint[i-1] : sleepPoint[j];
				}
				max = Math.max(wakeVal, max);
			}
		}
		System.out.println(wakePoint+max);
	}

}
