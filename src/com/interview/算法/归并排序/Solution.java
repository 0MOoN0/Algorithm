package com.interview.算法.归并排序;

public class Solution {
	
	// 合并数组
	public static void merge(int[] arr, int L, int R, int middle) {
		// 左右两边指针
		int p1 = L; int p2 = middle+1; int k = L;
		// 临时数组
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
	
	// 排序
	public static void sort(int[] arr, int L, int R) {
		if(L < R) {
			int middle = L+((R-L)>>1);
			// 左边排序
			sort(arr, L, middle);
			// 右边排序
			sort(arr, middle+1, R);
			// 合并左右两边排序
			merge(arr, L, R, middle);
		}
		
	}
	
}
