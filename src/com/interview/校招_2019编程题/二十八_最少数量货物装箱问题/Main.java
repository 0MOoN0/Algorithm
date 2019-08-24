package com.interview.У��_2019�����.��ʮ��_������������װ������;

import java.util.Arrays;
import java.util.Scanner;

/**
 * һά��̬�滮
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		int dp[] = new int[10001];
		Arrays.fill(dp, -1);
		dp[3]=1;
		dp[5]=1;
		dp[7]=1;
		for(int i=4; i<dp.length; i++) {
			int min = 0;
			int ans = Integer.MAX_VALUE;
			for(int j=3; j<=7; j+=2) {
				if(i>j && dp[i-j]>0) {
					min = dp[i-j]+1;
					ans = Math.min(ans, min);
					if(dp[i]==-1) {
						dp[i]=ans;
					}else {
						dp[i] = Math.min(dp[i], ans);
					}
				}
			}
			
		}
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(dp[i]);
	}

}
