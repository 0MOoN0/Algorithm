package com.interview.校招_2019编程题.三十二_求连续子数组的最大和;

import java.util.Scanner;

/**
 * 与leetcode第53.最大子序和相同，使用动态规划思路求解
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);
		String[] split = sc.nextLine().split(",");
		int ans=0, max=0;
		for(int i=0; i<split.length; i++) {
			int num = Integer.parseInt(split[i]);
			// 选择是否重开开始数组
			if(num>max+num) {
				max = num;
			}else {
				max = max + num;
			}
			ans = Math.max(ans, max);
		}
		System.out.println(ans);
	}

}
