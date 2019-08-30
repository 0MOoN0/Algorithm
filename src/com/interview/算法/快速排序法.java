package com.interview.算法;

import java.util.Arrays;

public class 快速排序法 {

	static int [] arr = {3,7,2,9,1,4,6,8,10,5};
	public static void main(String[] args) {
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	private static int partition(int []arr, int left, int right) {
		// 选择一个基准数，从左边开始
		int temp = arr[left];
		// 当左右游标不相等时，进行循环
		while(left<right) {
			// 左边基准数选择完后，开始与右边进行比较，直到右边的数比基准数小
			while(left<right && temp<=arr[right]) {
				right--;
			}
			// 找到比基准数小的右边，挖坑、填坑
			if(left<right) {
				arr[left] = arr[right];
				left++;
			}
			// 右边寻找完毕，从左边开始寻找
			while(left<right && temp>=arr[left]) {
				left++;
			}
			// 如果左边的数大于基准数
			if(left<right) {
				// 填坑
				arr[right] = arr[left];
				right--;
			}
		}
		// 填最后一个坑
		arr[left]=temp;
		// 左右游标相等时返回
		return left;
	}
	
	public static void sort(int arr[], int left, int right) {
		if(arr==null || left>=right || arr.length<=1) {
			return ;
		}
		int middle = partition(arr, left, right);
		sort(arr,left,middle);
		sort(arr,middle+1,arr.length-1);		
	}
	

}
