package com.interview.�㷨;

public class ȫ���� {

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
				swap(list, start, i);// ��������Ϊ����ÿһ���������Ҫ�ٶ���һλ�����п����ԵĻ�����ô�ͱ������ڽ�������Щ���еĳ�ʼ״̬һ�µ�����£�����Ҫ�ع�״̬
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
