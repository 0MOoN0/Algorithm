package com.interview.校招_2019编程题.十一_丰收;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用二分查找法解决
 * Arrays自带binarySearch，相当好用
 * 1. 如果查找的数在数组范围内，则返回略大于要查找的数的坐标(这个坐标是一个负值，真正在数组中的
 * 位置是：Math.abs(index)-1)
 * 2. 如果不在这个数组的范围内，返回-1
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pileSize = sc.nextInt();	// 堆的数量
		int [] piles = new int[pileSize];
		piles[0] = sc.nextInt();
		for(int j=1; j<pileSize; j++) {
			piles[j] = piles[j-1]+sc.nextInt();
		}
		int questSize = sc.nextInt();
		for(int i=0; i<questSize; i++) {
			int index = Arrays.binarySearch(piles, sc.nextInt());
			if(index == -1) {
				System.out.println(1);
			}else if(index<0) {
				System.out.println(Math.abs(index));
			}else {
				System.out.println(index+1);
			}
		}
	}
}
