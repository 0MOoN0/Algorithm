package com.interview.校招_2019编程题.十_瞌睡;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int classSize = sc.nextInt();
		int qx = sc.nextInt();
		int [][] split = new int[classSize][2];
		int result = 0;
		int qxPointBase = 0;
		for(int i=0; i<classSize; i++) {
			split[i][0] = sc.nextInt();
		}
		for(int i=0; i<classSize; i++) {
			split[i][1] = sc.nextInt();
			// 如果当前分钟为清醒，则加入qxPoint总和
			if(split[i][1]==1) {
				qxPointBase += split[i][0];
			}
		}
		// 再次遍历数组
		for(int i=0; i<classSize; i++) {
			// 判断当前分钟是否清醒
			if(split[i][1]!=1) {
				// 如果不清醒，则判断叫醒一次可以增加多少qxPoint
				int qxMax = qxPointBase;
				int step = 0;
				for(int j=i; j<classSize && step<qx; j++,step++) {
					// 判断叫醒以后的当前点是否为qxPoint;
					if(split[j][1]==1) {
						continue;
					}
					// 如果不为qxPoint，则加入qxPoint
					qxMax += split[j][0];
				}
				result = Math.max(qxMax, result);
			}
		}
		System.out.println(result);
	}

}
