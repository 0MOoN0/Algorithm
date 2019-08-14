package com.interview.У��_2019�����.��_ţţ�ı�������;

import java.util.Scanner;

/**
 * ʹ��DFS�ķ�������
 * 1. ������е���ʳ������װ�뱳���У�����C(n,0)+C(n,1)+C(n,2)+...C(n,n) = x^n
 * 2. ������ܽ�������ʳװ�뱳���У����еڶ��ַ���
 * 	2.1���磬�����1, 2, 3 ����ʳ������ÿһ�֣�����ѡ�Ͳ�ѡ�����
 * �Ӻ���ǰ�ƶϣ�
 * ���ѡ��3�� ����һ�ַ�����3����û��Ԫ�أ������DFS�л����ϻ���
 * �����2��ʼѡ������ѡ��3�Ͳ�ѡ��3�����
 * �����1��ʼѡ������ѡ��2�Ͳ�ѡ��2�����
 * 		����ѡ��2�Ͳ�ѡ��2������£���һ���أ�����ѡ��3�Ͳ�ѡ��3�����
 * ������������������ı������Ӹ��ڵ����������������
 * �߽��жϣ�
 * 1. �α겻�ܴ�������ĳ���
 * 2. ѡ�����ʳ�ܿռ䲻�ܴ��ڱ����Ŀռ�
 * 
 * @author Peter
 *
 */
public class Main {

	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int total = sc.nextInt();
		int [] nums = new int[size];
		int sum = 0;
		for(int i=0; i<size; i++) {
			nums[i] = sc.nextInt();
			// �����ܺ�
			sum += nums[i];
		}
		// ����ܺ�С����������ֱ�Ӽ�������
		if(sum<=total) {
			System.out.println((int)Math.pow(2, size));
			return ;
		}
		dfs(0, 0, total, size, nums);
		// ȫ��ѡҲ��һ�ֽⷨ
		System.out.println(++count);
	}
	
	public static void dfs(int sum,int cur, int total, int size, int []nums) {
		// ��Ԫ��ѹջ
		if(cur<size) {
			if(sum>total) {
				return ;
			}
			// ����ӽ�����
			dfs(sum, cur+1, total, size, nums);
			if(sum+nums[cur] <= total) {
				count++;
				// ������һ���ڵ�
				dfs(sum+=nums[cur], cur+1, total, size, nums);
			}
		}
	}
	

}
