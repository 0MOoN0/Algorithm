package com.interview.У��_2019�����.��_ţţ�ı�������.solution;

import java.util.Scanner;

public class Backup {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			count = 0;
			int n = scanner.nextInt();
			int total = scanner.nextInt();
			int[] nums = new int[n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
				sum += nums[i];
			}
			if (sum <= total) {
				System.out.println((int) Math.pow(2, n));
			} else {
				dfs(0, 0, n, nums, total);
//            �������Ҳ��һ�����
				System.out.println(count + 1);
			}
		}
	}
	private static void dfs(long sum, int cur, int n, int[] nums, int total) {
		if (cur < n) {
			if (sum > total) {
				return;
			}
//            ����������ʳ
			dfs(sum, cur + 1, n, nums, total);
			// ��ǰ������ӷ�ʽ����,��������ʳ
			if (sum + nums[cur] <= total) {
				count++;
				dfs(sum + nums[cur], cur + 1, n, nums, total);
			}
		}
	}
}