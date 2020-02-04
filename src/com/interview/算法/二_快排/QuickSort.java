package com.interview.�㷨.��_����;

import java.util.Arrays;

import com.interview.�㷨.utils.Utils;

/**
 * ����������������
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
			// �������
			swap(arr, L + (int)(Math.random()*(R-L+1)), R);
			// ѡ������ߵ���Ϊ��׼����������
			int[] partition = partition(arr, L, R, arr[R]);
			quickSort(arr, L, partition[0]-1);
			quickSort(arr, partition[1]+1, R);
		}
	}
	
	/**
	 * ���ֻ��֣����ƺ��������㷨������˼�룺����numС����������ߣ�����num���������м䣬����num���������ұ�
	 * @param arr	��������
	 * @param L
	 * @param R
	 * @param num
	 * @return
	 */
	public static int[] partition(int []arr, int L, int R, int num) {
		int less = L - 1;	// С�����򣬳�ʼΪ-1
		int more = R + 1;		// ��������
		// С��������±�С�ڴ���������±꣬ȷ����Խ��
		while(L < more) {
			if(arr[L] < num) {
				// ����Ƚϵ���С��num�����������С���������һ�������н���
				swap(arr, ++less, L++);
			}else if(arr[L] > num) {
				// ����Ƚϵ�������num����������뵱ǰָ��������н���
				swap(arr, --more, L); 
			}else {
				// ����Ƚϵ�����num��ȣ���ָ�������ƶ�һλ
				L++;
			}
		}
		// �����������
		return new int[]{less+1, more-1};
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	

}
