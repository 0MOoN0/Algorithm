package com.interview.校招_2019编程题.八_牛牛的背包问题;

import java.util.Scanner;

/**
 * 使用DFS的方法解题
 * 1. 如果所有的零食都可以装入背包中，则有C(n,0)+C(n,1)+C(n,2)+...C(n,n) = x^n
 * 2. 如果不能将所有零食装入背包中，则有第二种方法
 * 	2.1例如，如果有1, 2, 3 中零食，对于每一种，都有选和不选的情况
 * 从后往前推断：
 * 如果选择3， 则是一种方法，3后面没有元素，因此在DFS中会往上回溯
 * 如果从2开始选，则有选择3和不选择3的情况
 * 如果从1开始选，则有选择2和不选择2的情况
 * 		而在选择2和不选择2的情况下，进一步地，又有选择3和不选择3的情况
 * 这种情况，类似于树的遍历，从根节点遍历，遍历完后回溯
 * 边界判断：
 * 1. 游标不能大于数组的长度
 * 2. 选择的零食总空间不能大于背包的空间
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
			// 计算总和
			sum += nums[i];
		}
		// 如果总和小于总数，则直接计算出结果
		if(sum<=total) {
			System.out.println((int)Math.pow(2, size));
			return ;
		}
		dfs(0, 0, total, size, nums);
		// 全不选也是一种解法
		System.out.println(++count);
	}
	
	public static void dfs(int sum,int cur, int total, int size, int []nums) {
		// 将元素压栈
		if(cur<size) {
			if(sum>total) {
				return ;
			}
			// 不添加进背包
			dfs(sum, cur+1, total, size, nums);
			if(sum+nums[cur] <= total) {
				count++;
				// 访问下一个节点
				dfs(sum+=nums[cur], cur+1, total, size, nums);
			}
		}
	}
	

}
