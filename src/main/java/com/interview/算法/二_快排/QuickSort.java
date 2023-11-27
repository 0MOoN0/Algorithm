package com.interview.算法.二_快排;

import java.util.Arrays;

import com.interview.算法.utils.Utils;

/**
 * 经典快排与随机快排
 * @author Peter
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arrayG = Utils.arrayGenerator(1000);
		int[] arr2 = Utils.arrayCopy(arrayG);
		Arrays.sort(arrayG);
		quickSort(arr2, 0, arr2.length-1);
		System.out.println(Utils.arrayCompare(arrayG, arr2, true));
	}
	
	public static void quickSort(int []arr, int L, int R) {
		if(L < R) {
			// 随机快排
			swap(arr, L + (int)(Math.random()*(R-L+1)), R);
			// 选择最左边的数为基准，进行排序
			int[] partition = partition(arr, L, R, arr[R]);
			quickSort(arr, L, partition[0]);
			quickSort(arr, partition[1], R);
		}
	}
	
	/**
	 * 部分划分，类似荷兰国旗算法，核心思想：将比num小的数放在左边，等于num的数放在中间，大于num的数放在右边
	 * @param arr	待排数组
	 * @param L
	 * @param R
	 * @param num
	 * @return
	 */
	public static int[] partition(int []arr, int L, int R, int num) {
		int less = L - 1;	// 小于区域，初始为-1
		int more = R + 1;		// 大于区域
		// 小于区域的下标小于大于区域的下标，确保不越界
		while(L < more) {
			if(arr[L] < num) {
				// 如果比较的数小于num，则将这个数与小于区域的下一个数进行交换
				swap(arr, ++less, L++);
			}else if(arr[L] > num) {
				// 如果比较的数大于num，则将这个数与当前指向的数进行交换
				swap(arr, --more, L); 
			}else {
				// 如果比较的数与num相等，则指针往右移动一位
				L++;
			}
		}
		// 返回相等区间
		return new int[]{less, more};
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	

}
