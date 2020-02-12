package com.interview.�㷨.�鲢����;

public class Solution {
	
	// �ϲ�����
	public static void merge(int[] arr, int L, int R, int middle) {
		// ��������ָ��
		int p1 = L; int p2 = middle+1; int k = L;
		// ��ʱ����
		int [] temp = new int[arr.length];
		
		while(p1<=middle && p2<=R) {
			temp[k++] = arr[p1]<=arr[p2] ? arr[p1++]:arr[p2++];
		}
		while(p1<=middle) {
			temp[k++] = arr[p1++];
		}
		while(p2<=R) {
			temp[k++] = arr[p2++];
		}
		
		for(int i=L; i<=R;i++) {
			arr[i] = temp[i];
		}
	}
	
	// ����
	public static void sort(int[] arr, int L, int R) {
		if(L < R) {
			int middle = L+((R-L)>>1);
			// �������
			sort(arr, L, middle);
			// �ұ�����
			sort(arr, middle+1, R);
			// �ϲ�������������
			merge(arr, L, R, middle);
		}
		
	}
	
}
