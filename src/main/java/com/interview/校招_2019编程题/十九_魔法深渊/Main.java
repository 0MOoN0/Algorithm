package com.interview.校招_2019编程题.十九_魔法深渊;

import java.util.Scanner;

/**
 * 动态规划
 * @author Peter
 *
 */
public class Main {
	
	static final int  MOD = 1000000003;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 构建一个dp数组
		// 最长只有1000个台阶
		int [] dp = new int[1001];
		dp[0]=1;
		dp[1]=1;
		for(int i=2; i<dp.length; i++) {
			int temp=1;
			while(temp<=i) {
				dp[i]+=dp[i-temp];
				temp*=2;
				dp[i]%=MOD;
			}
		}
		// 输入
		int size = sc.nextInt();
		for(int i=0; i<size; i++) {
			//输出
			System.out.println(dp[sc.nextInt()]);
		}
		
		
		
	}

}
