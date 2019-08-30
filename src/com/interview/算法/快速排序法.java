package com.interview.�㷨;

import java.util.Arrays;

public class �������� {

	static int [] arr = {3,7,2,9,1,4,6,8,10,5};
	public static void main(String[] args) {
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	private static int partition(int []arr, int left, int right) {
		// ѡ��һ����׼��������߿�ʼ
		int temp = arr[left];
		// �������α겻���ʱ������ѭ��
		while(left<right) {
			// ��߻�׼��ѡ����󣬿�ʼ���ұ߽��бȽϣ�ֱ���ұߵ����Ȼ�׼��С
			while(left<right && temp<=arr[right]) {
				right--;
			}
			// �ҵ��Ȼ�׼��С���ұߣ��ڿӡ����
			if(left<right) {
				arr[left] = arr[right];
				left++;
			}
			// �ұ�Ѱ����ϣ�����߿�ʼѰ��
			while(left<right && temp>=arr[left]) {
				left++;
			}
			// �����ߵ������ڻ�׼��
			if(left<right) {
				// ���
				arr[right] = arr[left];
				right--;
			}
		}
		// �����һ����
		arr[left]=temp;
		// �����α����ʱ����
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
