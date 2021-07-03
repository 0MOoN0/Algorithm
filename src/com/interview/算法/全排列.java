package com.interview.算法;

public class 全排列 {

	public static void arrage(int[] list, int start, int length) {
		int i;
		if (start == length) {
			for (i = 0; i < length; i++)
				System.out.print(list[i] + " ");
			System.out.println();
		} else {
			for (i = start; i < length; i++) {
				swap(list, start, i);
				arrage(list, start + 1, length);
				swap(list, start, i);// 这里是因为我们每一次如果我们要假定第一位的所有可能性的话，那么就必须是在建立在这些序列的初始状态一致的情况下，所以要回归状态
			}
		}
	}

	public static void swap(int[] list, int start, int i) {
		int temp;
		temp = list[start];
		list[start] = list[i];
		list[i] = temp;
	}

	public static void main(String[] args) {
		int length = 3;
		int start = 0;
		int list[] = new int[length];
		for (int j = 0; j < length; j++)
			list[j] = j + 1;
		arrage(list, start, length);
	}

}
