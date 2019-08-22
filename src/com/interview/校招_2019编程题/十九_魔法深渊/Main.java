package com.interview.У��_2019�����.ʮ��_ħ����Ԩ;

import java.util.Scanner;

/**
 * ��̬�滮
 * @author Peter
 *
 */
public class Main {
	
	static final int  MOD = 1000000003;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ����һ��dp����
		// �ֻ��1000��̨��
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
		// ����
		int size = sc.nextInt();
		for(int i=0; i<size; i++) {
			//���
			System.out.println(dp[sc.nextInt()]);
		}
		
		
		
	}

}
